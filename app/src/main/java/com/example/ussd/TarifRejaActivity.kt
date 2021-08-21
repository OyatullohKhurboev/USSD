package com.example.ussd


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ussd.Fragment.PageType

import com.example.ussd.TabLayout.TablayoutAdapterTarifReja
import com.example.ussd.model.TarifRejaModel
import com.example.ussd.model.TariffsCategoriesModel
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_mb_paket_.*
import kotlinx.android.synthetic.main.activity_tarif_reja.*


class TarifRejaActivity : AppCompatActivity() {
    val tarifList = ArrayList<TarifRejaModel>()
    lateinit var tabLayout_tarif: TabLayout
    lateinit var viewPager_tarif: ViewPager
    var tablayoutAdapter: TablayoutAdapterTarifReja? = null
    var categories = arrayOf("asd")
    var pageType: PageType = PageType.Beeline

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarif_reja)
        setSupportActionBar(toolbar_tarif)

        supportActionBar?.apply {
            title = "Tarif Rejalar"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        pageType = intent.getSerializableExtra("dillerType") as PageType

        when (pageType) {
            PageType.Ucell -> getCategoriesUcell()
            PageType.Beeline -> getCategoriesBeeline()
            PageType.Uzmobile -> getCategoriesUzmobile()
            PageType.Mobiuz -> getCategoriesMobiuz()

        }

        tabLayout_tarif = findViewById(R.id.tabLayout_tarif)
        viewPager_tarif = findViewById(R.id.viewPager_tarif)






        when (pageType) {
            PageType.Mobiuz -> {
                tabLayout_tarif.background = ContextCompat.getDrawable(this, R.color.mobiuz)
                tabLayout_tarif.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.mobiuz))
            }
            PageType.Ucell -> {
                tabLayout_tarif.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.ucell))
                toolbar_tarif.background = ContextCompat.getDrawable(this, R.color.ucell)
            }
            PageType.Beeline -> {
                tabLayout_tarif.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.beeline))
                toolbar_tarif.background = ContextCompat.getDrawable(this, R.color.beeline)
            }
            PageType.Uzmobile -> {
                tabLayout_tarif.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.uzmobile))
                toolbar_tarif.background = ContextCompat.getDrawable(this, R.color.uzmobile)
            }
        }

    }

    fun addCategoriesToTab() {
        for (category in categories) {
            tabLayout_tarif.addTab(tabLayout_tarif.newTab().setText(category))

            tabLayout_tarif.tabGravity = TabLayout.GRAVITY_FILL
            tablayoutAdapter =
                TablayoutAdapterTarifReja(this,
                    supportFragmentManager,
                    tabLayout_tarif.tabCount,
                    pageType, categories)

            viewPager_tarif.adapter = tablayoutAdapter
            viewPager_tarif.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(
                tabLayout_tarif))
            tabLayout_tarif.tabMode = TabLayout.MODE_SCROLLABLE
            tabLayout_tarif.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager_tarif.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })

        }
    }

    private fun getCategoriesUcell() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/de87ddab-da2f-4606-baf2-d996023d8b7a"

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
        val url = "https://run.mocky.io/v3/942a7cfb-21f6-49f3-b714-07bd57191871"

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

    private fun getCategoriesBeeline() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/5b0be5c4-416a-425f-8a0d-af8939867d43"

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
    private fun getCategoriesUzmobile() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/c5f0813b-d65e-4450-a3c8-7499a20fb6c8"

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
