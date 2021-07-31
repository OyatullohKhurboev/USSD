package com.example.ussd.TabLayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ussd.Fragment.PageType
import com.example.ussd.Fragment.SmsToplamFragment

internal class TablayoutAdapterSmsToplam(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    val pageType: PageType
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                SmsToplamFragment(0, pageType)
            }
            1 -> {
                SmsToplamFragment(1, pageType)
            }
            2 -> {
                SmsToplamFragment(2, pageType)
            }
            else -> SmsToplamFragment(1, pageType)
        }


    }

    override fun getCount(): Int {
        return totalTabs
    }
}
