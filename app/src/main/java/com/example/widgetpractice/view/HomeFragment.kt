package com.example.widgetpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.widgetpractice.R
import com.example.widgetpractice.databinding.FragmentHomeBinding

class HomeFragment: Fragment(), OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 버튼 리스너 달기
        binding.dropdownBtn.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.dropdownBtn -> {
                findNavController().navigate(R.id.action_homeFragment_to_dropdownFragment)
            }
        }
    }
}