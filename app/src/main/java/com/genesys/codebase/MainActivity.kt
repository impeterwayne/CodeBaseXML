package com.genesys.codebase

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.genesys.codebase.databinding.ActivityMainBinding
import com.genesys.codebase.placeholder.ComponentFragment
import com.genesys.codebase.placeholder.InboxFragment
import com.genesys.codebase.placeholder.SettingsFragment
import com.genesys.core.ui.R as UiR
import com.genesys.core.ui.base.BaseActivity
import com.genesys.core.ui.custom.CustomBottomNavigationView
import com.genesys.feature.template.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun statusBarInsetTarget(): View {
        return mBinding.topline
    }

    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            val itemId = when (position) {
                0 -> CustomBottomNavigationView.ItemId.TEMPLATES
                1 -> CustomBottomNavigationView.ItemId.COMPONENT
                2 -> CustomBottomNavigationView.ItemId.INBOX
                3 -> CustomBottomNavigationView.ItemId.SETTINGS
                else -> CustomBottomNavigationView.ItemId.TEMPLATES
            }
            mBinding.bottomNavigation.selectItem(itemId)
        }
    }

    override fun initViews() {
        mBinding.viewPager.apply {
            adapter = MainPagerAdapter(this@MainActivity)
            offscreenPageLimit = 3
            isUserInputEnabled = false
            registerOnPageChangeCallback(onPageChangeCallback)
        }
    }

    override fun onClickViews() {
        mBinding.bottomNavigation.onItemClickListener = { itemId ->
            val targetIndex = when (itemId) {
                CustomBottomNavigationView.ItemId.TEMPLATES -> 0
                CustomBottomNavigationView.ItemId.COMPONENT -> 1
                CustomBottomNavigationView.ItemId.INBOX -> 2
                CustomBottomNavigationView.ItemId.SETTINGS -> 3
            }
            mBinding.viewPager.setCurrentItem(targetIndex, false)
        }

        mBinding.btnCenterAction.setOnClickListener {
            Toast.makeText(this, UiR.string.nav_primary_clicked, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding.viewPager.unregisterOnPageChangeCallback(onPageChangeCallback)
    }

    private class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> MainFragment()
                1 -> ComponentFragment()
                2 -> InboxFragment()
                3 -> SettingsFragment()
                else -> MainFragment()
            }
        }
    }
}
