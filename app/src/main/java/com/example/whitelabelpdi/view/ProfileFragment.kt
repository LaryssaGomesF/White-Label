package com.example.whitelabelpdi.view

import android.os.Bundle
import android.view.View
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.databinding.FragmentProfileBinding
import com.example.whitelabelpdi.view.common.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar()
    }

    private fun setUpToolbar(){
        setDisplayHome(false)
        setToolbarTitle(R.string.title_profile)
    }

}