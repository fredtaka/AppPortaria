/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fsct.android.appportaria.regentradatracker

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fsct.android.appportaria.database.RegistroDatabaseDao
import com.fsct.android.appportaria.database.Registro
import com.fsct.android.appportaria.formatRegistros
import kotlinx.coroutines.launch

/**
 * ViewModel for RegentradaFragment.
 */
class RegentradaViewModel(
    dataSource: RegistroDatabaseDao,
    application: Application) : ViewModel() {

    /**
     * Hold a reference to RegistroDatabase via RegistroDatabaseDao.
     */
    val database = dataSource

    private var esseRegistro = MutableLiveData<Registro?>()

    val registros = database.getTodosRegistros()

    /**
     * Converted registros to Spanned for displaying.
     */
    val registrosString = Transformations.map(registros) { registros ->
        formatRegistros(registros, application.resources)
    }

    /**
     * If esseRegistro has not been set, then the START button should be visible.
     */
//    val startButtonVisible = Transformations.map(esseRegistro) {
//        null == it
//    }
//
//    /**
//     * If esseRegistro has been set, then the STOP button should be visible.
//     */
//    val stopButtonVisible = Transformations.map(esseRegistro) {
//        null != it
//    }
//
//    /**
//     * If there are any registros in the database, show the CLEAR button.
//     */
//    val clearButtonVisible = Transformations.map(registros) {
//        it?.isNotEmpty()
//    }

    /**
     * Request a toast by setting this value to true.
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     */
    private var _showSnackbarEvent = MutableLiveData<Boolean?>()

    /**
     * If this is true, immediately `show()` a toast and call `doneShowingSnackbar()`.
     */
    val showSnackBarEvent: LiveData<Boolean?>
        get() = _showSnackbarEvent

    /**
     * Variable that tells the Fragment to navigate to a specific [SleepQualityFragment]
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     * modificado do original (abaixo) para evitar erro de variável não nullable
     *     private val _navigateToCpf = MutableLiveData<Registro>()

     */
    private val _navigateToCpf = MutableLiveData<Boolean?>()
    val navigateToCpf: LiveData<Boolean?>
        get() = _navigateToCpf



    //opção: https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br

    //Seguindo: https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150
    //Recomendação oficial de 2022: https://medium.com/androiddevelopers/viewmodel-one-off-event-antipatterns-16a1da869b95


    /**
     * Call this immediately after calling `show()` on a toast.
     *
     * It will clear the toast request, so if the user rotates their phone it won't show a duplicate
     * toast.
     */
    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = null
    }

    /**
     * Call this immediately after navigating to [SleepQualityFragment]
     *
     * It will clear the navigation request, so if the user rotates their phone it won't navigate
     * twice.
     */
    fun doneNavigating() {
        _navigateToCpf.value = null
    }

//    init {
//        initializeEsseRegistro()
//    }
//
//    private fun initializeEsseRegistro() {
//        viewModelScope.launch {
//            esseRegistro.value = getEsseRegistroFromDatabase()
//        }
//    }
//
//    /**
//     *  Handling the case of the stopped app or forgotten recording,
//     *  the start and end times will be the same.j
//     *
//     *  If the start time and end time are not the same, then we do not have an unfinished
//     *  recording.
//     */
//    private suspend fun getEsseRegistroFromDatabase(): Registro? {
//        var registro = database.getEsseRegistro()
//        if (registro?.horaSaidaMs != registro?.horaEntradaMs) {
//            registro = null
//        }
//        return registro
//    }
//
//    private suspend fun insert(registro: Registro) {
//        database.insert(registro)
//    }
//
    private suspend fun update(registro: Registro) {
        database.update(registro)
    }

//
//    private suspend fun clear() {
//        database.clear()
//    }

    /**
     * Executes when the START button is clicked.
     */
    fun onEntradaSaida() {
        viewModelScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
            //val novoRegistro = Registro()

            //insert(novoRegistro)

            //esseRegistro.value = getEsseRegistroFromDatabase()

            // Set state to navigate to the CpfFragment.
            //_navigateToCpf.value = novoRegistro


            _navigateToCpf.value = true
        }
    }

    /**
     * Executes when the STOP button is clicked.
     */
    fun onStop() {
        viewModelScope.launch {
            // In Kotlin, the return@label syntax is used for specifying which function among
            // several nested ones this statement returns from.
            // In this case, we are specifying to return from launch().
            val velhoRegistro = esseRegistro.value ?: return@launch

            // Update the night in the database to add the end time.
            velhoRegistro.horaSaidaMs = System.currentTimeMillis()

            update(velhoRegistro)

            // Set state to navigate to the CpfFragment.
            _navigateToCpf.value = true
        }
    }

}
