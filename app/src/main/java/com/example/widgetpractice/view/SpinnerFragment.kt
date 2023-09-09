package com.example.widgetpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.widgetpractice.R
import com.example.widgetpractice.databinding.FragmentSpinnerBinding

class SpinnerFragment: Fragment() {

    private var _binding: FragmentSpinnerBinding? = null
    private val binding get() = _binding!!

    // 선택한 값을 저장할 변수
    private var selectedValue: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpinnerBinding.inflate(inflater, container, false)

        // 스피너에 들어갈 데이터
        val spinnerList = arrayOf("합격", "불합격")

        // ArrayAdapter를 사용하여 스피너에 데이터 연결
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, spinnerList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner1.adapter = adapter

        // 스피너에서 항목을 선택했을 때 이벤트 처리
        binding.spinner1.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedValue = spinnerList[position]
                // 선택한 값을 변수에 저장
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedValue = null
                // 아무것도 선택되지 않았을 때 변수를 초기화
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}