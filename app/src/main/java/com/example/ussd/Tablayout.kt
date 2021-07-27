package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.ussd.Fragment_uzmobile.PageType
import com.example.ussd.adapters.TabLayoutAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tablayout.*

class Tablayout : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var toolBar: Toolbar
    lateinit var viewPager: ViewPager

    val categories = arrayOf("Kunlik", "Hafalik", "Oylik", "Tungi", "TASIX")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Mb To'plam"


            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val pageType: PageType = intent.getSerializableExtra("dillerType") as PageType




        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category))

        }


        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val toolbarAdapter =
            TabLayoutAdapter(this, supportFragmentManager, tabLayout.tabCount, pageType)

        viewPager.adapter = toolbarAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })



        when (pageType) {
            PageType.Mobiuz ->
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.mobiuz))
        }
        when (pageType) {
            PageType.Ucell ->
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ucell))
        }
        when (pageType) {
            PageType.Beeline ->
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.beeline))
        }
        when (pageType) {
            PageType.Uzmobile ->
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.uzmobile))

        }
//        when (pageType) {
//            PageType.Uzmobile ->
//                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.uzmobile))
//
//        }
//        when (pageType) {
//            PageType.Beeline ->
//                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.beeline))
//
//        }
//        when (pageType) {
//            PageType.Ucell ->
//                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.ucell))
//
//        }
//        when (pageType) {
//            PageType.Mobiuz ->
//                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.mobiuz))
//
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}