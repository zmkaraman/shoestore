package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private var mShoeList = emptyList<Shoe>()

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )

        setHasOptionsMenu(true)

        shoeListViewModel.shoeList.value?.let {
            mShoeList = it
        }

        shoeListViewModel.eventShoeAdd.observe(viewLifecycleOwner, Observer {
            if (it) {
                mShoeList = shoeListViewModel.shoeList.value!!
            }
        })

        binding.listRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(mShoeList)

        }

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        // Disable onBack click
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // With blank your fragment BackPressed will be disabled.
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}