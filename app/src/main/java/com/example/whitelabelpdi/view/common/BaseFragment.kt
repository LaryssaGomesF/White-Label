package com.example.whitelabelpdi.view.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.common.extensions.getBinding
import com.google.android.material.appbar.MaterialToolbar

open class BaseFragment<T : ViewBinding> : Fragment() {
    /**
     * BINDING ATTRIBUTES
     */
    private lateinit var _binding: T

    val binding: T
        get() = _binding

    private var baseActivity: BaseActivity<*>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        instantiateViewBinding(inflater, container)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            if (it is BaseActivity<*>) {
                baseActivity = it
            }
        }
    }

    fun onBackPressed() {
        activity?.onBackPressed()
    }

    /**
     * BINDING METHODS
     */
    private fun instantiateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) {
        _binding = getBinding(inflater, container)
    }

    fun showLoading() {
        baseActivity?.showLoading()
    }

    fun hideLoading() {
        baseActivity?.hideLoading()
    }

    /**
     * TOOLBAR METHODS
     */
    fun setUpToolbar(
        toolbar: MaterialToolbar,
        title: Int,
        leftIcon: Int = R.drawable.icon_arrow_back,
    ) {
        (requireActivity() as BaseActivity<*>).setUpToolbar(
            toolbar = toolbar,
            title = title,
            leftIcon = leftIcon
        )
    }

    fun setDisplayHome(isEnable: Boolean) {
        (requireActivity() as BaseActivity<*>).setDisplayHome(isEnable)
    }

    fun setToolbarTitle(@StringRes title: Int) {
        (requireActivity() as BaseActivity<*>).setToolbarTitle(title)
    }

    fun setToolbarTitle(title: String) {
        (requireActivity() as BaseActivity<*>).setToolbarTitle(title)
    }

    fun setToolbarSubTitle(subtitle: String) {
        (requireActivity() as BaseActivity<*>).setToolbarSubtitle(subtitle)
    }

    fun setHomeAsUpIndicator(@DrawableRes resId: Int) {
        (requireActivity() as BaseActivity<*>).setHomeAsUpIndicator(resId)
    }
}