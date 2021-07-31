package com.example.ussd.TabLayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ussd.Fragment.PageType
import com.example.ussd.Fragment.TarifRejaFragment

internal class TablayoutAdapterTarifReja(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    val pageType: PageType
) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {

               return when (position) {
            0 -> {
                TarifRejaFragment(0, pageType)
            }
            1 -> {
                TarifRejaFragment(1, pageType)
            }
            2 -> {
                TarifRejaFragment(2, pageType)
            }
            else -> TarifRejaFragment(0, pageType)
        }
   }

    }

