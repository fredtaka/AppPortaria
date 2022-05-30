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

import AuthResultContract
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.fsct.android.appportaria.R
import com.fsct.android.appportaria.cpf.CpfFragmentDirections
import com.fsct.android.appportaria.databinding.FragmentLoginBinding
import com.fsct.android.appportaria.login.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    companion object {
        const val TAG = "LoginFragment"
        const val RC_SIGN_IN = 1001
    }

    // Get a reference to the ViewModel scoped to this Fragment.
    private val viewModel by viewModels<LoginViewModel>()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment.
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )

        binding.authButton.setOnClickListener { authResultLauncher.launch(RC_SIGN_IN) }

        return binding.root

    }

    private val authResultLauncher =
        registerForActivityResult(AuthResultContract()) { idpResponse ->
            handleAuthResponse(idpResponse)
        }

    private fun handleAuthResponse(idpResponse: IdpResponse?) {
        when {
            (idpResponse == null || idpResponse.error != null) -> {
                /* Handle error from returned data. */

            }
            else -> {
                /* Handle sign-in success from returned data. */
                this.findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToRegentradaFragment())
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
    }



}
