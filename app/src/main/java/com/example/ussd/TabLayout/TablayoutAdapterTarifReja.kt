package com.example.ussd.TabLayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ussd.Fragment.PageType
import com.example.ussd.Fragment.TarifRejaFragment
import com.example.ussd.model.TariffsCategoriesModel

class TablayoutAdapterTarifReja(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    val pageType: PageType,
    var categories: Array<String>,
) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    fun addCategories(c: Array<String>) {
        categories = c
    }

    override fun getItem(position: Int): Fragment {

        return TarifRejaFragment(categories[position], pageType)
    }
}


