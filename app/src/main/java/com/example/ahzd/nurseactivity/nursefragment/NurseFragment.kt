package com.example.ahzd.nurseactivity.nursefragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R

class NurseFragment : Fragment(R.layout.fragment_nurse_beds_overview), OnItemClickListener, OnLongClickCallback {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bedsAdapter: BedsAdapter
    private lateinit var bendNumbers: List<Int>
    private val listOfCLicks = mutableListOf<Int>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.recyclerview)
        bendNumbers = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        R.drawable.bed

        bedsAdapter = BedsAdapter(requireContext(), bendNumbers, this, this)

        recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = bedsAdapter
        }
    }

    override fun onItemClick(position: Int) {
        if (listOfCLicks.isEmpty()) {
            listOfCLicks.add(position)
            bedsAdapter.setClickablePosition(position)
            Log.d("TestIF1",bedsAdapter.positionsClickable.toString())

        } else {

            if (listOfCLicks[0] == position) {
                bedsAdapter.getAll()
                Log.d("TestIF2",bedsAdapter.positionsClickable.toString())

            } else {
                Log.d("TestIF3",bedsAdapter.positionsClickable.toString())
                return
            }

        }
    }

    override fun addPatientToBed() {
        val action = NurseFragmentDirections.actionNurseBedsOverviewFragmentToAddPatient()
        findNavController().navigate(action)
    }

}
