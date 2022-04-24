package com.example.ahzd.nurseactivity.nursefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R

class NurseBedsOverviewFragment : Fragment(R.layout.fragment_nurse_beds_overview) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bedsAdapter: BedsAdapter
    private lateinit var listofBedsNumbers : List<String>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.recyclerview)
        listofBedsNumbers = arrayListOf("1","2","3","4","5","6","7","8","9","10")
        val imageOfBed = R.drawable.beddd

        bedsAdapter = BedsAdapter(listofBedsNumbers,imageOfBed)

        recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
            adapter = bedsAdapter
        }
    }
}