package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ussd.Fragment.PageType
import com.example.ussd.adapters.UssdKodlarAdapter
import com.example.ussd.model.UssdInfoModel
import com.example.ussd.model.UssdResponseModel
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_ussd_kodlar.*

class UssdKodlarActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var adapter: UssdKodlarAdapter? = null
    var pageType: PageType = PageType.Beeline

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ussd_kodlar)
        setSupportActionBar(toolbar_ussd)
        supportActionBar?.apply {
            title = "USSD kodlar"


        }
        pageType = intent.getSerializableExtra("dillerType") as PageType

        when (pageType) {
            PageType.Mobiuz -> callApiToGetInfoAboutMobiuz()
            PageType.Ucell -> callApiToGetInfoAboutUcell()
            PageType.Beeline -> callApiToGetInfoAboutBeeline()
            PageType.Uzmobile -> callApiToGetInfoAboutMobiuzUzmobile()
        }
        recyclerView = findViewById(R.id.rv_ussd)


        when (pageType) {
            PageType.Mobiuz -> {

                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.mobiuz)

            }
            PageType.Ucell -> {
                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.ucell)

            }
            PageType.Beeline -> {
                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.beeline)


            }
            PageType.Uzmobile -> {
                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.uzmobile)

            }
        }

    }

    private fun callApiToGetInfoAboutUcell() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/2a1f84e3-a2dc-4254-a7ea-487824a0be81"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, UssdResponseModel::class.java)
                adapter = UssdKodlarAdapter(this, model.data, pageType)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
//                adapter?.reloadData(model.data)

            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

    private fun callApiToGetInfoAboutBeeline() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/1d515be0-f62b-44e3-b63e-e8f0961f5d24"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, UssdResponseModel::class.java)
                adapter = UssdKodlarAdapter(this, model.data, pageType)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
//                adapter?.reloadData(model.data)

            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }


    private fun callApiToGetInfoAboutMobiuz() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/e636a518-d79d-4d86-a93e-817f12194c18"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, UssdResponseModel::class.java)
                adapter = UssdKodlarAdapter(this, model.data, pageType)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
//                adapter?.reloadData(model.data)

            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutMobiuzUzmobile() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/6c99a183-cd79-40f4-9b6d-26ed2da8b4e9"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, UssdResponseModel::class.java)
                adapter = UssdKodlarAdapter(this, model.data, pageType)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
//                adapter?.reloadData(model.data)

            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}