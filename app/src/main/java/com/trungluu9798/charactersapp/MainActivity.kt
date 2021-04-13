package com.trungluu9798.charactersapp

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.trungluu9798.charactersapp.view.detail.DetailFragment
import com.trungluu9798.charactersapp.view.list.ListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chooseOrientation()
        if (savedInstanceState == null) {
            chooseLayout()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.commit{
                add<ListFragment>(R.id.fragment_container_view, "list")
            }
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.commit{
                add<ListFragment>(R.id.fragment_container_view, "list")
            }
        }
    }


    fun chooseOrientation() {
        val screenLayoutSize = resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
        if (screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenLayoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }

    fun chooseLayout() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.commit{
                add<ListFragment>(R.id.fragment_container_view, "list")
            }
        } else {
            supportFragmentManager.commit{
                add<ListFragment>(R.id.fragment_container_view, "list")
            }
        }
    }

    fun replaceFragment() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.commit{
                replace<DetailFragment>(R.id.fragment_container_view, "detail")
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        } else {
            if (supportFragmentManager.findFragmentByTag("detail") == null) {
                supportFragmentManager.commit {
                    add<DetailFragment>(R.id.fragment_second_pane, "detail")
                }
            } else {
                (supportFragmentManager.findFragmentByTag("detail") as DetailFragment).updateUI()
            }
        }
    }

    override fun onBackPressed() {
        Log.d("FAIL", "FAIL")
        supportFragmentManager?.popBackStackImmediate()
    }
}