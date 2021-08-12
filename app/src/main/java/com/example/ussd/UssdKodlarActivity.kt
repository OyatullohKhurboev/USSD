package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.core.content.ContextCompat
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

class UssdKodlarActivity(val type: String, val pageType: PageType): AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var adapter: UssdKodlarAdapter ?= null

    private var ussdList = ArrayList<UssdInfoModel>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ussd_kodlar)
        setSupportActionBar(toolbar_ussd)
        supportActionBar?.apply {
            title = "USSD kodlar"


        }
        val pageType: PageType = intent.getSerializableExtra("dillerType") as PageType



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
                callApiToGetInfoAboutUssd()
            }
        }

    }

    private fun callApiToGetInfoAboutUssd() {

        val queue = Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/2a1f84e3-a2dc-4254-a7ea-487824a0be81"
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model =   Gson().fromJson(result, UssdResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        ussdList.add(data)
                }
                adapter?.reloadData(ussdList)
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