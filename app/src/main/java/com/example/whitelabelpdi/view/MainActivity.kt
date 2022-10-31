package com.example.whitelabelpdi.view

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.databinding.ActivityMainBinding
import com.example.whitelabelpdi.view.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavHost()
        setUpToolbar()
        configureBottomNavigation()
    }

    private fun initNavHost() {
        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.home_nav_host_fragment
        ) as NavHostFragment
    }

    private fun setUpToolbar() {
        setUpToolbar(
            binding.toolbar,
            R.string.title_empty
        )
        setDisplayHome(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configureBottomNavigation() {
        navHostFragment.navController.apply {
            binding.bnBottomNavigate.setupWithNavController(this)
        }
    }


}