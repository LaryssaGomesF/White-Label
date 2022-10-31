package com.example.whitelabelpdi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.databinding.FragmentScheduleBinding
import com.example.whitelabelpdi.view.common.BaseFragment

class ScheduleFragment : BaseFragment<FragmentScheduleBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar()
    }

    private fun setUpToolbar() {
        setDisplayHome(false)
        setToolbarTitle(R.string.title_schedule)
    }
}