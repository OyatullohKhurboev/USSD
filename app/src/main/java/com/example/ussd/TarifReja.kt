package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.ussd.Fragment.PageType
import com.example.ussd.adapters.TabLayoutAdapter
import com.example.ussd.adapters.TarifRejaAdapter
import com.example.ussd.model.TarifRejaModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_mb_paket_umumiy.*
import kotlinx.android.synthetic.main.activity_tarif_reja.*


class TarifReja : AppCompatActivity() {
    val tarifList = ArrayList<TarifRejaModel>()
    lateinit var tabLayout_tarif: TabLayout
    lateinit var viewPager_tarif: ViewPager
    val categories = arrayOf("Kunlik", "Hafalik", "Oylik", "Tungi", "TASIX")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarif_reja)
        setSupportActionBar(toolbar_tarif)

        supportActionBar?.apply {
            title = "Tarif Rejalar"


            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val pageType: PageType = intent.getSerializableExtra("dillerType") as PageType


        tabLayout_tarif = findViewById(R.id.tabLayout_tarif)
        viewPager_tarif = findViewById(R.id.viewPager_tarif)

        for (category in categories) {
            tabLayout_tarif.addTab(tabLayout_tarif.newTab().setText(category))

        }

        tabLayout_tarif.tabGravity = TabLayout.GRAVITY_FILL
        val tablayoutAdapter =
            TabLayoutAdapter(this, supportFragmentManager, tabLayout_tarif.tabCount, pageType)

        viewPager_tarif.adapter = tablayoutAdapter
        viewPager_tarif.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout_tarif))
        tabLayout_tarif.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager_tarif.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })



        when (pageType) {
            PageType.Mobiuz ->
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.mobiuz))
            PageType.Ucell -> {

                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.ucell))
            }
            PageType.Beeline ->
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.beeline))
            PageType.Uzmobile ->
                tabLayout_tarif.setBackgroundColor(ContextCompat.getColor(this, R.color.uzmobile))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
