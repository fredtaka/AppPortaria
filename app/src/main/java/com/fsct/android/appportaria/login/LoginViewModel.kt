/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fsct.android.appportaria.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LoginViewModel : ViewModel() {

    companion object {
        val androidFacts = arrayOf(
            "The first commercial Android device was launched in September 2008",
            "The Android operating system has over 2 billion monthly active users",
            "The first Android version (1.0) was released on September 23, 2008",
            "The first smart phone running Android was the HTC Dream called the T-Mobile G1 in " + "some countries"
        )

        val californiaFacts = arrayOf(
            "The most populated state in the United States is California",
            "Three out of the ten largest U. S. cities are in California",
            "The largest tree in the world can be found in California",
            "California became a state in 1850"
        )
    }

    /** VINDO do CpfViewModel
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


    /*TODO: maioria das funcionalidades removidas daqui -> remover resto? */

    /**
     * Gets a fact to display based on the user's set preference of which type of fact they want
     * to see (Android fact or California fact). If there is no logged in user or if the user has
     * not set a preference, defaults to showing Android facts.
     */
    fun getFactToDisplay(context: Context): String {


        return androidFacts[Random.nextInt(0, androidFacts.size)]
    }
}
