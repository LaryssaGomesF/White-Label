package com.example.whitelabelpdi.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.whitelabelpdi.common.pagestate.ErrorState
import com.example.whitelabelpdi.common.pagestate.LoadingState
import com.example.whitelabelpdi.common.pagestate.NoneState
import com.example.whitelabelpdi.common.pagestate.SuccessState
import com.example.whitelabelpdi.databinding.FragmentHomeBinding
import com.example.whitelabelpdi.view.adapters.ClassesAdapters
import com.example.whitelabelpdi.view.adapters.HomeAdapters
import com.example.whitelabelpdi.view.common.BaseFragment
import com.example.whitelabelpdi.view.model.ClassesView
import com.example.whitelabelpdi.view.model.HomeItemView
import com.example.whitelabelpdi.view.viewmodel.ClassesViewModel
import com.example.whitelabelpdi.view.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private val homeAdapter: HomeAdapters by lazy {
        HomeAdapters()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerViewHomeFeatures()
        setUpObservers()
        getFeatures()
    }

    private fun getFeatures() {
        viewModel.getFeatures()
    }

    private fun setUpObservers() {
        viewModel.featuresHome.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoadingState -> {
                    showLoading()
                }
                is SuccessState -> {
                    successGetFeatures(state.value)
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

    private fun successGetFeatures(list: List<HomeItemView>) {
        homeAdapter.setItems(list)
    }

    private fun setUpRecyclerViewHomeFeatures() {
        setAdapterRecyclerView()
        setOnClickRecyclerViewHomeFeatures()
    }

    private fun setOnClickRecyclerViewHomeFeatures() {
        homeAdapter.setOnClick {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show() //Navigate here after
        }
    }

    private fun setAdapterRecyclerView() {
        binding.recyclerViewHome.adapter = homeAdapter
    }


}