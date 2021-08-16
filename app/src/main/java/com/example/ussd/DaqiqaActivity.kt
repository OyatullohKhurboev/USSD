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
import com.example.ussd.TabLayout.TablayoutAdapterDaqiqa
import com.example.ussd.model.TariffsCategoriesModel
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_daqiqa.*
import kotlinx.android.synthetic.main.activity_tarif_reja.*

class DaqiqaActivity : AppCompatActivity() {
    lateinit var tablayout: TabLayout
    lateinit var viewPager: ViewPager
    var tablayoutAdapter: TablayoutAdapterDaqiqa? = null
    var categories = arrayOf("asd")
    var pageType: PageType = PageType.Beeline

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daqiqa)
        setSupportActionBar(toolbar_tarif)

        supportActionBar?.apply {
            title = "DaqiqaMinutlar"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        pageType = intent.getSerializableExtra("dillerType") as PageType



        tablayout = findViewById(R.id.tablayout_daqiqa)
        viewPager = findViewById(R.id.vp_daqiqa)





        getCategories()

        when (pageType) {
            PageType.Mobiuz -> {
                toolbar_daqiqa.background = ContextCompat.getDrawable(this, R.color.mobiuz)
                tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.mobiuz))
            }
            PageType.Ucell -> {
                tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.ucell))
                toolbar_daqiqa.background = ContextCompat.getDrawable(this, R.color.ucell)
            }
            PageType.Beeline -> {
                tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.beeline))
                toolbar_daqiqa.background = ContextCompat.getDrawable(this, R.color.beeline)
            }
            PageType.Uzmobile -> {
                tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,
                    R.color.uzmobile))
                toolbar_daqiqa.background = ContextCompat.getDrawable(this, R.color.uzmobile)
            }
        }

    }

    fun addCategoriesToTab() {
        for (category in categories) {
            tablayout.addTab(tablayout.newTab().setText(category))

            tablayout.tabGravity = TabLayout.GRAVITY_FILL
            tablayoutAdapter =
                TablayoutAdapterDaqiqa(this,
                    supportFragmentManager,
                    tablayout.tabCount,
                    pageType, categories)

            vp_daqiqa.adapter = tablayoutAdapter
            vp_daqiqa.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(
                tablayout))
            tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    vp_daqiqa.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })

        }
    }

    private fun getCategories() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/3082c586-dc6c-4b56-a51b-055a4e839202"

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
