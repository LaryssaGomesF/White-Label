package com.example.whitelabelpdi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        configureBottomNavigation()
    }

    private fun initNavHost() {
        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.home_nav_host_fragment
        ) as NavHostFragment
    }

    private fun configureBottomNavigation() {
        navHostFragment.navController.apply {
            binding.bnBottomNavigate.setupWithNavController(this)
        }
    }

}