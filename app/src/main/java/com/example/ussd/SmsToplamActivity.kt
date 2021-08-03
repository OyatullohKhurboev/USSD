package com.example.ussd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.ussd.Fragment.PageType
import com.example.ussd.TabLayout.TablayoutAdapterSmsToplam
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_sms_paket.*

class SmsToplamActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    val categories = arrayOf("Kunlik", "Hafalik", "Oylik", "Tungi", "TASIX")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_paket)
        setSupportActionBar(toolbar_sms)

        supportActionBar?.apply {
            title = "SMS To'plam"

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val pageType: PageType = intent.getSerializableExtra("dillerType") as PageType




        tabLayout = findViewById(R.id.tabLayout_sms)
        viewPager = findViewById(R.id.viewPager_sms)

        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category))

        }

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val toolbarAdapter =
            TablayoutAdapterSmsToplam(this, supportFragmentManager, tabLayout.tabCount, pageType)

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
                tabLayout_sms.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.mobiuz))
                toolbar_sms.background = ContextCompat.getDrawable(this, R.color.mobiuz)

            }
            PageType.Ucell -> {
                toolbar_sms.background = ContextCompat.getDrawable(this, R.color.ucell)
                tabLayout_sms.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.ucell))

            }
            PageType.Beeline -> {
                toolbar_sms.background = ContextCompat.getDrawable(this, R.color.beeline)


                tabLayout_sms.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.beeline))
            }
            PageType.Uzmobile -> {
                toolbar_sms.background = ContextCompat.getDrawable(this, R.color.uzmobile)

                tabLayout_sms.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.uzmobile))
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}