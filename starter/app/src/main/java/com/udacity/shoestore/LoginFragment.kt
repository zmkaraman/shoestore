package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)

        binding.newAccountButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        binding.existingAccountButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        return binding.root
    }
}
