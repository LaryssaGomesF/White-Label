package com.example.whitelabelpdi.view.common

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.common.extensions.getBinding
import com.example.whitelabelpdi.view.common.dialog.LoadingDialogFragment
import com.google.android.material.appbar.MaterialToolbar


open class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    /**
     * BINDING ATTRIBUTES
     */
    lateinit var binding: T
    var progress: LoadingDialogFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instantiateBinding()
        setContentView(binding.root)
    }

    /**
     * BINDING METHODS
     */
    private fun instantiateBinding() {
        binding = getBinding()
    }

    fun showLoading() {
        try {
            progress = LoadingDialogFragment.newInstance()
            progress?.showNow(supportFragmentManager, "progress_fragment")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideLoading() {
        try {
            progress?.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * TOOLBAR METHODS
     */

    fun setUpToolbar(
        toolbar: MaterialToolbar,
        title: Int,
        leftIcon: Int = R.drawable.icon_arrow_back,
    ) {
        toolbar.title = getString(title)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setHomeAsUpIndicator(leftIcon)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
        }
    }

    fun setDisplayHome(isEnable: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(isEnable)
    }

    fun setToolbarTitle(@StringRes title: Int) {
        supportActionBar?.title = getString(title)
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun setToolbarSubtitle(subtitle: String) {
        supportActionBar?.subtitle = subtitle
    }

    fun setHomeAsUpIndicator(@DrawableRes resId: Int) {
        supportActionBar?.setHomeAsUpIndicator(resId)
    }
}