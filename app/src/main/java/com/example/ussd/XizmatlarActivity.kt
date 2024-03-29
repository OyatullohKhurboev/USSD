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
import com.example.ussd.adapters.ServiceAdapter
import com.example.ussd.adapters.UssdKodlarAdapter
import com.example.ussd.model.UssdResponseModel
import com.example.ussd.model.XizmatlarResponseModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_ussd_kodlar.*
import kotlinx.android.synthetic.main.activity_xizmatlar.*

class XizmatlarActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var adapter: ServiceAdapter? = null
    var pageType: PageType = PageType.Beeline

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xizmatlar)
        setSupportActionBar(toolbar_service)
        supportActionBar?.apply {
            title = "Xizmatlar"
            pageType = intent.getSerializableExtra("dillerType") as PageType
            when(pageType){
                PageType.Ucell -> callApiToGetInfoAboutUcell()
                PageType.Beeline -> callApiToGetInfoAboutBeeline()
                PageType.Mobiuz -> callApiToGetInfoAboutMobiuz()
                PageType.Uzmobile -> callApiToGetInfoAboutUzmobile()
            }
        }



        recyclerView = findViewById(R.id.rv_service)


        when (pageType) {
            PageType.Mobiuz -> {

                toolbar_service.background = ContextCompat.getDrawable(this, R.color.mobiuz)

            }
            PageType.Ucell -> {
                toolbar_service.background = ContextCompat.getDrawable(this, R.color.ucell)

            }
            PageType.Beeline -> {
                toolbar_service.background = ContextCompat.getDrawable(this, R.color.beeline)


            }
            PageType.Uzmobile -> {
                toolbar_service.background = ContextCompat.getDrawable(this, R.color.uzmobile)
                pageType  = intent.getSerializableExtra("dillerType") as PageType

            }
        }

    }

    private fun callApiToGetInfoAboutUcell() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/f89abf73-5fdc-4c44-84f1-d675cd8e148b"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, XizmatlarResponseModel::class.java)
                adapter = ServiceAdapter(this, model.data, pageType)
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

        val url = "https://run.mocky.io/v3/a7a041e2-92de-446e-9985-2efb3bbfc4bd"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, XizmatlarResponseModel::class.java)
                adapter = ServiceAdapter(this, model.data, pageType)
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

        val url = "https://run.mocky.io/v3/5e5c90f8-af9e-4be5-b3c7-1e15614a401a"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, XizmatlarResponseModel::class.java)
                adapter = ServiceAdapter(this, model.data, pageType)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
//                adapter?.reloadData(model.data)

            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutUzmobile() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/b9389ebd-e354-4745-80db-82ef3ce8b136"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, XizmatlarResponseModel::class.java)
                adapter = ServiceAdapter(this, model.data, pageType)
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