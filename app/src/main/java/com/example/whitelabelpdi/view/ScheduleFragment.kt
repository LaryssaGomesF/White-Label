package com.example.whitelabelpdi.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.common.pagestate.ErrorState
import com.example.whitelabelpdi.common.pagestate.LoadingState
import com.example.whitelabelpdi.common.pagestate.NoneState
import com.example.whitelabelpdi.common.pagestate.SuccessState
import com.example.whitelabelpdi.databinding.FragmentScheduleBinding
import com.example.whitelabelpdi.view.adapters.ScheduleAdapter
import com.example.whitelabelpdi.view.common.BaseFragment
import com.example.whitelabelpdi.view.model.ScheduleEvent
import com.example.whitelabelpdi.view.viewmodel.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleFragment : BaseFragment<FragmentScheduleBinding>() {

    private val viewModel: ScheduleViewModel by viewModels()
    private val adapterSchedule: ScheduleAdapter by lazy {
        ScheduleAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar()
        setUpObservers()
        setUpAdapter()
        viewModel.getEvents()
    }

    private fun setUpToolbar() {
        setDisplayHome(false)
        setToolbarTitle(R.string.title_schedule)
    }

    private fun setUpAdapter() {
        setAdapterRecyclerView()
        setOnClickRecyclerView()
    }

    private fun setAdapterRecyclerView() {
        binding.recyclerViewEvents.apply {
            adapter = adapterSchedule
            layoutManager = LinearLayoutManager(requireContext())

        }
    }

    private fun setOnClickRecyclerView() {
        adapterSchedule.setOnClick {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpObservers() {
        viewModel.events.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoadingState -> {
                    showLoading()
                }
                is SuccessState -> {
                    successGetEvents(state.value)
                    hideLoading()
                }
                is ErrorState -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
                is NoneState -> {
                    onBackPressed()
                }
            }

        }
    }

    private fun successGetEvents(list: List<ScheduleEvent>) {
        adapterSchedule.addItems(list)
    }
}