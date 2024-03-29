package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ussd.Fragment.PageType
import com.example.ussd.TabLayout.TabLayoutAdapterMbPaket
import com.example.ussd.model.TariffsCategoriesModel
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_mb_paket_.*
import kotlinx.android.synthetic.main.activity_mb_paket_.view.*


class MbPaketActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var tablayoutAdapter: TabLayoutAdapterMbPaket? = null
    var categories = arrayOf("Kunlik")
    var pageType: PageType = PageType.Ucell

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mb_paket_)
        setSupportActionBar(toolbar)
        pageType = intent.getSerializableExtra("dillerType") as PageType

        supportActionBar?.apply {
            title = "Mb To'plam"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        when (pageType) {
            PageType.Beeline -> getCategoriesBeeline()
            PageType.Ucell -> getCategoriesUcell()
            PageType.Mobiuz -> getCategoriesMobiuz()
            PageType.Uzmobile -> getCategoriesUZmobile()
        }



        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)




        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE


        when (pageType) {
            PageType.Mobiuz -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.mobiuz)
                tabLayout.background = ContextCompat.getDrawable(this, R.color.mobiuz)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.mobiuz))

            }
            PageType.Ucell -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.ucell)
                tabLayout.background = ContextCompat.getDrawable(this, R.color.ucell)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.ucell))

            }
            PageType.Beeline -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.beeline)
                tabLayout.background = ContextCompat.getDrawable(this, R.color.beeline)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.beeline))
            }
            PageType.Uzmobile -> {
                toolbar.background = ContextCompat.getDrawable(this, R.color.uzmobile)
                tabLayout.background = ContextCompat.getDrawable(this, R.color.uzmobile)
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.uzmobile))
            }
        }

    }

    fun addCategoriesToTab() {
        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category))

        }

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tablayoutAdapter =
            TabLayoutAdapterMbPaket(this,
                supportFragmentManager,
                tabLayout.tabCount,
                pageType,
                categories)

        viewPager.adapter = tablayoutAdapter


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
        val url = "https://run.mocky.io/v3/b5743fb3-dc5a-4cd9-ae0f-4b0f8a999578"

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
        val url = "https://run.mocky.io/v3/c11cdea9-0935-4f45-a861-5807fe8e1714"

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
        val url = "https://run.mocky.io/v3/493163b8-443b-49b0-9557-932087e70b44"

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

    private fun getCategoriesUZmobile() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/641dc04d-8369-40e8-b57b-869ca4ece240"

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