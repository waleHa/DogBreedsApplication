package com.example.dogbreeds.ui.DogBreed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.dogbreeds.R
import com.example.dogbreeds.core.Constant
import com.example.dogbreeds.databinding.FragmentDogBreedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class DogBreedFragment : Fragment() {
    private lateinit var binding: FragmentDogBreedBinding
    private val viewModel: DogBreedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDogBreedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinner()
        observe()
    }

    private fun observe() {
        viewModel.breed.observe(viewLifecycleOwner) {
            Log.i("TAG: DogBreedFragment", it.message.toString())
            Glide.with(view?.context!!)
                .load(it?.message)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageViewRandom)
        }
    }


    private fun setupSpinner() {
        // Assuming Constant.breedsNameList is correctly initialized and contains list of breeds
        val adapter = ArrayAdapter(
            requireContext(), // Use requireContext() to get the context safely
            android.R.layout.simple_spinner_item,
            Constant.breedsNameList.map { it.capitalize() } // This should be a list of strings
        )

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        binding.spinnerDogBreeds.adapter = adapter

        // Set an item selected listener
        binding.spinnerDogBreeds.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem = parent.getItemAtPosition(position).toString()
//                    Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT)
//                        .show()

                    viewModel.loadProducts(selectedItem.lowercase())
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Optional implementation if you want to handle the case where nothing is selected
                }
            }
    }
}
