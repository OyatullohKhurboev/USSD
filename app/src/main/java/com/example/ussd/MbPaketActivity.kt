package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.ussd.Fragment.PageType
import com.example.ussd.TabLayout.TabLayoutAdapterMbPaket
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_mb_paket_.*



class MbPaketActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    val categories = arrayOf("Kunlik", "Hafalik", "Oylik", "Tungi", "TASIX")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mb_paket_)
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
            TabLayoutAdapterMbPaket(this, supportFragmentManager, tabLayout.tabCount, pageType)

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
            PageType.Mobiuz -> {
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.mobiuz))
                toolbar.background = ContextCompat.getDrawable(this, R.color.mobiuz)

            }
            PageType.Ucell -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.ucell)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.ucell))

            }
            PageType.Beeline -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.beeline)


                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.beeline))
            }
            PageType.Uzmobile -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.uzmobile)

                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.uzmobile))
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}