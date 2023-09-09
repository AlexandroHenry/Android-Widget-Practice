package com.example.widgetpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetpractice.adapter.AdapterListener
import com.example.widgetpractice.adapter.RecyclerAdapter
import com.example.widgetpractice.data.RecyclerData
import com.example.widgetpractice.databinding.FragmentRecyclerBinding

class RecyclerFragment: Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    private var listItems = arrayListOf<RecyclerData>(
        RecyclerData("Google", "GOOGL", 291.19, 281.22,293.21,78998299),
        RecyclerData("Apple", "AAPL", 1364.19, 365.22,395.21,12312292),
        RecyclerData("Microsoft", "MSFT", 322.19, 365.22,395.21,3312122),
        RecyclerData("Amazon", "AMZN", 322.19, 365.22,395.21,12334545),
        RecyclerData("Tesla", "TSLA", 3128.19, 365.22,395.21,8899800),
        RecyclerData("Adobe", "ADBE", 239.19, 365.22,395.21,2189128),
        RecyclerData("Coca Cola", "KO", 90.19, 365.22,395.21,321983791),
        RecyclerData("McDonald", "MCD", 210.19, 365.22,395.21,12382781),
        RecyclerData("Starbucks", "SBUX", 130.00, 365.22,395.21,2129102),
        RecyclerData("Meta", "META", 200.19, 365.22,395.21,1239120),
        RecyclerData("Nike", "NKE", 123.19, 365.22,395.21,1231235),
        RecyclerData("UnitedHealth Group", "UNH", 390.19, 365.22,395.21,1222121),
        RecyclerData("Lockheed Martin", "LMT", 390.19, 365.22,395.21,1212312),
        RecyclerData("Berkshire Hathaway Inc.", "BRK-A", 547336.06, 547336.22,553220.21,7374)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        with(binding) {

//            val nestedScrollView = nestedScrollView
            val recyclerView = recyclerView

            // 2열로 설정
//            val layoutManager = GridLayoutManager(requireContext(), 2)
            val layoutManager = GridLayoutManager(requireContext(), 1)

            // 세로 스크롤
            layoutManager.orientation = RecyclerView.VERTICAL
            // 가로 스크롤
//            layoutManager.orientation = RecyclerView.HORIZONTAL
            recyclerView.layoutManager = layoutManager

            recyclerView.adapter = RecyclerAdapter(listItems, adapterListener)

//            // NestedScrollView와 RecyclerView 연결
//            nestedScrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
//                recyclerView.scrollBy(scrollX - oldScrollX, scrollY - oldScrollY)
//            }
        }

        return binding.root
    }

    private val adapterListener = object : AdapterListener {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}