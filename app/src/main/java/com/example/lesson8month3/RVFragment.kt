package com.example.lesson8month3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson8month3.databinding.FragmentRVBinding

class RVFragment : Fragment() {

    private lateinit var binding: FragmentRVBinding
    private lateinit var itemAdapter: ItemAdapter
    private val itemList = ArrayList<Items>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        itemAdapter = ItemAdapter(itemList){
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_view, DetailFragment()).addToBackStack(null).commit()
        }
        binding.rvItems.adapter = itemAdapter
    }

    private fun onLoad() {
        itemList.add(Items("Image", "Name", "Description", "Price$"))
        itemList.add(Items("Image", "Name", "Description", "Price$"))
        itemList.add(Items("Image", "Name", "Description", "Price$"))
        itemList.add(Items("Image", "Name", "Description", "Price$"))
        itemList.add(Items("Image", "Name", "Description", "Price$"))
        itemList.add(Items("Image", "Name", "Description", "Price$"))

    }
}