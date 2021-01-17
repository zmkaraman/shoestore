package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_detail_fragment.*


class ShoeDetailFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    private var shoe  = Shoe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        binding.shoe = shoe

        binding.saveButton.setOnClickListener {

            if (validateShoeDetails()) {

                shoeListViewModel.addShoe(shoe)
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            } else {
                Toast.makeText(activity, "Please correct the shoe details", Toast.LENGTH_LONG).show()
            }
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        return binding.root
    }

    private fun validateShoeDetails(): Boolean {

        val name = shoe.name ?: ""
        val size = shoe.size.toString()
        val company = shoe.company ?: ""
        val description = shoe.description ?: ""

        return !(name.isEmpty() || size.isEmpty() || company.isEmpty() || description.isEmpty())

    }

}