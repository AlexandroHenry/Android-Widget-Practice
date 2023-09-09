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

//    override fun onDestroyView() 메서드는 Fragment가 연결된 뷰를 파괴할 때 호출되는 메서드입니다. 즉, Fragment가 화면에서 사라지면 해당 Fragment의 레이아웃과 관련된 뷰들이 파괴됩니다. 이 때 _binding 변수를 null로 설정하여 메모리 누수(memory leak)를 방지하는 역할을 합니다.
//
//    코드 해석:
//
//    override fun onDestroyView()는 Fragment의 생명주기 메서드 중 하나로, Fragment의 레이아웃이 제거될 때 호출됩니다.
//
//    super.onDestroyView()는 부모 클래스의 onDestroyView() 메서드를 호출하는 것을 의미합니다. 부모 클래스의 메서드를 호출하여 필요한 정리 작업을 수행할 수 있습니다.
//
//    _binding = null은 _binding 변수에 null 값을 할당하는 부분입니다. _binding 변수는 Fragment의 레이아웃과 관련된 View Binding을 통해 생성된 바인딩 객체를 참조합니다. 레이아웃이 파괴되면 이 바인딩 객체를 더 이상 사용할 필요가 없으므로 null로 설정하여 메모리 누수를 방지합니다.
//
//    따라서 onDestroyView() 메서드 내의 _binding = null 코드는 Fragment의 뷰와 관련된 리소스를 정리하고 메모리를 해제하기 위한 일반적인 관례입니다. 이렇게 하면 Fragment가 다시 생성될 때 뷰 바인딩이 새로 초기화될 것이며, 메모리 누수가 방지됩니다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}