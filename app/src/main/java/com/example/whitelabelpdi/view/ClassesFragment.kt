package com.example.whitelabelpdi.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.whitelabelpdi.common.pagestate.ErrorState
import com.example.whitelabelpdi.common.pagestate.LoadingState
import com.example.whitelabelpdi.common.pagestate.NoneState
import com.example.whitelabelpdi.common.pagestate.SuccessState
import com.example.whitelabelpdi.databinding.FragmentClassesBinding
import com.example.whitelabelpdi.view.adapters.ClassesAdapters
import com.example.whitelabelpdi.view.common.BaseFragment
import com.example.whitelabelpdi.view.model.ClassesView
import com.example.whitelabelpdi.view.viewmodel.ClassesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassesFragment : BaseFragment<FragmentClassesBinding>() {

    private val viewModel: ClassesViewModel by viewModels()

    private val classesAdapters: ClassesAdapters by lazy {
        ClassesAdapters()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getClasses()
        setUpRecyclerViewClasses()
        setUpObservers()
        setUpToolbar()
    }


    private fun getClasses() {
        viewModel.getClasses("")
    }

    private fun setUpToolbar(){
        setDisplayHome(true)
    }

    private fun setUpObservers() {
        viewModel.classes.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoadingState -> {
                    showLoading()
                }
                is SuccessState -> {
                    successGetClasses(state.value)
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

    private fun successGetClasses(list: List<ClassesView>) {
        classesAdapters.setItems(list)
    }

    private fun setUpRecyclerViewClasses() {
        setAdapterRecyclerView()
        setOnClickRecyclerViewClasses()
    }

    private fun setOnClickRecyclerViewClasses() {
        classesAdapters.setOnClick {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show() //Navigate here after
        }
    }

    private fun setAdapterRecyclerView() {
        binding.recyclerViewClasses.adapter = classesAdapters
    }

}