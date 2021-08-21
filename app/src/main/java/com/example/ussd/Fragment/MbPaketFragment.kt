package com.example.ussd.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ussd.R
import com.example.ussd.adapters.InternetPaketAdapter
import com.example.ussd.model.MbPaketInfoModel
import com.example.ussd.model.MbPaketResponseModel
import com.google.gson.Gson
import android.content.Intent.getIntent





class MbPaketFragment(val type: String, val pageType: PageType) : Fragment() {

    private lateinit var rvInternet: RecyclerView
    private lateinit var adapter: InternetPaketAdapter
    private var internetList = ArrayList<MbPaketInfoModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_mb_paket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       when(pageType){
           PageType.Ucell -> callApiToGetInfoAboutUcell()
           PageType.Beeline -> callApiToGetInfoAboutBeeline()
           PageType.Mobiuz -> callApiToGetInfoAboutMobiuz()
           PageType.Uzmobile -> callApiToGetInfoAboutUzmobile()
       }


        rvInternet = view.findViewById(R.id.rvMbPAket)
        rvInternet.layoutManager = LinearLayoutManager(context)
        adapter = InternetPaketAdapter(requireActivity(), internetList, pageType)
        rvInternet.adapter = adapter

    }

    private fun callApiToGetInfoAboutUcell() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/af48c1e7-098e-477b-aefe-e635012543b7"
        internetList = ArrayList<MbPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, MbPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        internetList.add(data)
                }

                adapter.reloadData(internetList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutMobiuz() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/834df8bb-96a1-441d-ba82-8e3b89c00896"
        internetList = ArrayList<MbPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, MbPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        internetList.add(data)
                }

                adapter.reloadData(internetList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutBeeline() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/aab36454-2914-4c64-9240-02230f3f5661"
        internetList = ArrayList<MbPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, MbPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        internetList.add(data)
                }

                adapter.reloadData(internetList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)


}
    private fun callApiToGetInfoAboutUzmobile() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/861d9bec-2d9e-4cab-99cc-a3b3db935f0a"
        internetList = ArrayList<MbPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, MbPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        internetList.add(data)
                }

                adapter.reloadData(internetList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)


}}

