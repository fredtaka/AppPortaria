

package com.fsct.android.appportaria.cpf


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fsct.android.appportaria.database.RegistroDatabaseDao

/**
 * This is pretty much boiler plate code for a ViewModel Factory.
 *
 * Provides the key for the night and the RegistroDatabaseDao to the ViewModel.
 */
class CpfViewModelFactory(
    private val registroKey: Long,
    private val dataSource: RegistroDatabaseDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CpfViewModel::class.java)) {
            return CpfViewModel(registroKey, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
