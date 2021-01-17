package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)

        binding.newAccountButton.setOnClickListener {

            if (validateCredentials()) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                Toast.makeText(activity, "Incorrect email/password", Toast.LENGTH_LONG).show()
            }
        }
        binding.existingAccountButton.setOnClickListener {
            if (validateCredentials()) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                Toast.makeText(activity, "Incorrect email/password", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    private fun validateCredentials(): Boolean {

        return true

        //TODO MERVE test amacli
        val name = email_edittext.text.toString()
        val password = password_edittext.text.toString()

        return !(name.isEmpty() || password.isEmpty())

    }
}
