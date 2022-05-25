

package com.fsct.android.appportaria.regentradatracker


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fsct.android.appportaria.database.RegistroDatabaseDao

/**
 * This is pretty much boiler plate code for a ViewModel Factory.
 *
 * Provides the RegistroDatabaseDao and context to the ViewModel.
 */
class RegentradaViewModelFactory(
    private val dataSource: RegistroDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegentradaViewModel::class.java)) {
            return RegentradaViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
