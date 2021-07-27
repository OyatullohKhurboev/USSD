package com.example.ussd.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ussd.Fragment_uzmobile.MbPaket
import com.example.ussd.Fragment_uzmobile.PageType

internal class TabLayoutAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    val pageType: PageType
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MbPaket(0, pageType)
            }
            1 -> {
                MbPaket(1, pageType)
            }
            2 -> {
                MbPaket(2, pageType)
            }
            else -> MbPaket(1, pageType)
        }

    }

    override fun getCount(): Int {
        return totalTabs
    }
}
