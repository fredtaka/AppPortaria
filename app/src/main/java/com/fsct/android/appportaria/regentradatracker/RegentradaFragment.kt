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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fsct.android.appportaria.R
import com.fsct.android.appportaria.database.RegistroDatabase
import com.fsct.android.appportaria.databinding.FragmentRegentradaBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A fragment with buttons to record start and end times for sleep, which are saved in
 * a database. Cumulative data is displayed in a simple scrollable TextView.
 * (Because we have not learned about RecyclerView yet.)
 * The Clear button will clear all data from the database.
 */
class RegentradaFragment : Fragment() {

    /**
     * Called when the Fragment is ready to display content to the screen.
     *
     * This function uses DataBindingUtil to inflate R.layout.fragment_sleep_quality.
     *
     * It is also responsible for passing the [RegentradaViewModel] to the
     * [FragmentRegentradaBinding] generated by DataBinding. This will allow DataBinding
     * to use the [LiveData] on our ViewModel.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentRegentradaBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_regentrada, container, false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = RegistroDatabase.getInstance(application).registroDatabaseDao
        val viewModelFactory = RegentradaViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val regentradaViewModel =
                ViewModelProvider(
                        this, viewModelFactory).get(RegentradaViewModel::class.java)

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.regentradaViewModel = regentradaViewModel

        val adapter = RegentradaAdapter()
        binding.registroList.adapter = adapter

        regentradaViewModel.registros.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        // Specify the current activity as the lifecycle owner of the binding.
        // This is necessary so that the binding can observe LiveData updates.
        binding.setLifecycleOwner(this)

        // Add an Observer on the state variable for showing a Snackbar message
        // when the CLEAR button is pressed.
        regentradaViewModel.showSnackBarEvent.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        getString(R.string.cleared_message),
                        Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
                // Reset state to make sure the toast is only shown once, even if the device
                // has a configuration change.
                regentradaViewModel.doneShowingSnackbar()
            }
        })

        // Add an Observer on the state variable for Navigating when STOP button is pressed.
        regentradaViewModel.navigateToCpf.observe(viewLifecycleOwner, Observer { registro ->
            registro?.let {
                // We need to get the navController from this, because button is not ready, and it
                // just has to be a view. For some reason, this only matters if we hit stop again
                // after using the back button, not if we hit stop and choose a quality.
                // Also, in the Navigation Editor, for Quality -> Tracker, check "Inclusive" for
                // popping the stack to get the correct behavior if we press stop multiple times
                // followed by back.
                // Also: https://stackoverflow.com/questions/28929637/difference-and-uses-of-oncreate-oncreateview-and-onactivitycreated-in-fra
                this.findNavController().navigate(
                        RegentradaFragmentDirections
                                .actionRegentradaFragmentToCpfFragment(registro.registroId))
                // Reset state to make sure we only navigate once, even if the device
                // has a configuration change.
                regentradaViewModel.doneNavigating()
            }
        })
        return binding.root
    }
}