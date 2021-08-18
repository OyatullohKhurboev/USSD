package com.example.ussd

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ussd.Fragment.PageType
import com.example.ussd.TabLayout.TablayoutAdapterSmsToplam
import com.example.ussd.model.TariffsCategoriesModel
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sms_paket.*

class SmsToplamActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var tablayoutAdapter: TablayoutAdapterSmsToplam? = null
    var categories = arrayOf("Oylik SMS")
    var pageType: PageType = PageType.Ucell


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_paket)
        setSupportActionBar(toolbar_sms)
        pageType = intent.getSerializableExtra("dillerType") as PageType
        supportActionBar?.apply {
            title = "SMS To'plam"

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

        }


        tabLayout = findViewById(R.id.tabLayout_sms)
        viewPager = findViewById(R.id.viewPager_sms)
        when (pageType) {
            PageType.Ucell -> getCategoriesUcell()
            PageType.Mobiuz -> getCategoriesMobiuz()
        }

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

    fun addCategoriesToTab() {
        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category))

        }

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val toolbarAdapter = TablayoutAdapterSmsToplam(this,
            supportFragmentManager,
            tabLayout.tabCount,
            pageType, categories)

        viewPager.adapter = toolbarAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }


    private fun getCategoriesUcell() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/746126f1-e057-4002-bdee-f6c87caa309a"

        val request = object : StringRequest(Method.GET, url,
            Response.Listener { result ->
                val categories = Gson().fromJson(result, TariffsCategoriesModel::class.java)
                this.categories = categories.names
                tablayoutAdapter?.addCategories(categories.names)
                addCategoriesToTab()
            }, Response.ErrorListener { error ->
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)
    }

    private fun getCategoriesMobiuz() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/5299d720-0adc-496f-9acf-e6a8b03218a1"

        val request = object : StringRequest(Method.GET, url,
            Response.Listener { result ->
                val categories = Gson().fromJson(result, TariffsCategoriesModel::class.java)
                this.categories = categories.names
                tablayoutAdapter?.addCategories(categories.names)
                addCategoriesToTab()
            }, Response.ErrorListener { error ->
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
