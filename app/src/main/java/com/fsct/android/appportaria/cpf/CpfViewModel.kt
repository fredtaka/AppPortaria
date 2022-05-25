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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fsct.android.appportaria.database.RegistroDatabaseDao
import kotlinx.coroutines.launch

/**
 * ViewModel for CpfFragment.
 *
 * @param registroKey The key of the current night we are working on.
 */
class CpfViewModel(
    private val registroKey: Long = 0L,
    dataSource: RegistroDatabaseDao) : ViewModel() {

    /**
     * Hold a reference to RegistroDatabase via its RegistroDatabaseDao.
     */
    val database = dataSource

    /**
     * Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [Fragment]
     */
    private val _navigateToRegentrada = MutableLiveData<Boolean?>()

    /**
     * When true immediately navigate back to the [SleepTrackerFragment]
     */
    val navigateToRegentrada: LiveData<Boolean?>
        get() = _navigateToRegentrada

    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    fun doneNavigating() {
        _navigateToRegentrada.value = null
    }

    /**
     * Sets the sleep quality and updates the database.
     *
     * Then navigates back to the RegentradaFragment.
     */
    fun onSetSleepQuality(quality: Int) {
        viewModelScope.launch {
            val esseRegistro = database.get(registroKey)
            esseRegistro.grupoPessoa = quality
            database.update(esseRegistro)

            // Setting this state variable to true will alert the observer and trigger navigation.
            _navigateToRegentrada.value = true
        }
    }
}
