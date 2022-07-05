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

package com.fsct.android.appportaria.cpf

import androidx.lifecycle.*
import com.fsct.android.appportaria.database.Registro
import com.fsct.android.appportaria.database.RegistroDatabaseDao
import kotlinx.coroutines.launch

/**
 * ViewModel for CpfFragment.
 *
 * @param registroKey The key of the current night we are working on.
 */
class CpfViewModel(
    dataSource: RegistroDatabaseDao) : ViewModel() {

    /**
     * Hold a reference to RegistroDatabase via its RegistroDatabaseDao.
     */
    val database = dataSource

    private var esseRegistro = MutableLiveData<Registro?>()

    // inspirado em: https://stackoverflow.com/questions/63823276/how-to-get-livedata-value-from-edittext-and-display-it-in-a-textview-using-kotli
    // LiveData for the number entered by the user
    val cpfDigitado = MutableLiveData<String>()





    /**
     * Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [Fragment]
     */
    private val _navigateToRegentrada = MutableLiveData<Boolean?>()
    val navigateToRegentrada: LiveData<Boolean?>
        get() = _navigateToRegentrada

    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    fun doneNavigating() {
        _navigateToRegentrada.value = null
    }

    //TODO: mover isso para só iniciar registro se confirmar a entrada/saída
    init {
        initializeEsseRegistro()
        cpfDigitado.value = "0"
    }

    private fun initializeEsseRegistro() {
        viewModelScope.launch {
            esseRegistro.value = getEsseRegistroFromDatabase()
        }
    }

    /**
     *  Handling the case of the stopped app or forgotten recording,
     *  the start and end times will be the same.j
     *
     *  If the start time and end time are not the same, then we do not have an unfinished
     *  recording.
     */
    private suspend fun getEsseRegistroFromDatabase(): Registro? {
        var registro = database.getEsseRegistro()
//        if (registro?.horaSaidaMs != registro?.horaEntradaMs) {
//            registro = null
//        }
        return registro
    }

    private suspend fun insert(registro: Registro) {
        database.insert(registro)
    }

    private suspend fun update(registro: Registro) {
        database.update(registro)
    }


    private suspend fun clear() {
        database.clear()
    }

    /**
     * Sets the sleep quality and updates the database.
     *
     * Then navigates back to the RegentradaFragment.
     */
//    fun onSetSleepQuality(quality: Int) {
//        viewModelScope.launch {
//            val esseRegistro = database.get(registroKey)
//            esseRegistro.grupoPessoa = quality
//            database.update(esseRegistro)
//
//            // Setting this state variable to true will alert the observer and trigger navigation.
//            _navigateToRegentrada.value = true
//        }
//    }


    //TODO: corrigir variável de entrada pelo exemplo de https://medium.com/swlh/how-data-binding-helps-you-when-working-with-edittext-inside-recyclerview-543a1eb5f2cc
    // checar o bindable em https://developer.android.com/topic/libraries/data-binding/two-way
    fun onConfirmaEntrada() {
        viewModelScope.launch {
            val novoRegistro = Registro()

            insert(novoRegistro)

//            esseRegistro.value = getEsseRegistroFromDatabase() // já fez em cima



            //esseRegistro.cpfPessoa = cpfDigitado

            //val esseRegistro = database.get(sleepNightKey) //TODO: descobrir como é gerado esse valor no sleepTracker
            //esseRegistro.cpfPessoa = cpfDigitado.value!!.toInt()
            //database.update(esseRegistro)


            //database.update(esseRegistro)

            val oldNight = esseRegistro.value ?: return@launch

            oldNight.cpfPessoa = cpfDigitado.value()

            update(oldNight)

            // Setting this state variable to true will alert the observer and trigger navigation.
            _navigateToRegentrada.value = true
        }
    }
}
