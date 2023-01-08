package com.example.hw7m3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw7m3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: CharacterAdapter
    private lateinit var list: ArrayList<Model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lodData()
        adapter = CharacterAdapter(list, this::theclick)
        binding.recyclerview.adapter = adapter
    }

    private fun lodData() {
        list = ArrayList()
        list.add(Model(R.drawable.img, "Rick and Morty"))
        list.add(Model(R.drawable.img_1, "Rick"))
        list.add(Model(R.drawable.img_2, "Morty"))
        list.add(Model(R.drawable.img_3, "Sanchez"))
        list.add(Model(R.drawable.img_4, "Maks"))
    }

    private fun theclick(pos: Int) {
        val bundle = Bundle()
        bundle.putSerializable("key", list[pos])
        findNavController().navigate(R.id.secondFragment, bundle)
    }

}