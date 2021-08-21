package com.example.ussd.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ussd.R
import com.example.ussd.adapters.InternetPaketAdapter
import com.example.ussd.adapters.SmsToplamAdapter
import com.example.ussd.model.*
import com.google.gson.Gson

class SmsToplamFragment(val type: String, val pageType: PageType) : Fragment() {


    private lateinit var rvSms: RecyclerView
    private lateinit var adapter: SmsToplamAdapter
    private var smsList = ArrayList<SmsPaketInfoModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_sms_toplam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (pageType) {
            PageType.Beeline -> callApiToGetInfoAboutSmsBeelie()
            PageType.Mobiuz -> callApiToGetInfoAboutSmsMobiuz()
            PageType.Uzmobile -> callApiToGetInfoAboutSmsUzmobile()
            PageType.Ucell -> callApiToGetInfoAboutSmsUcell()
        }

        rvSms = view.findViewById(R.id.rv_sms_toplam)
        rvSms.layoutManager = LinearLayoutManager(context)
        adapter = SmsToplamAdapter(requireContext(), smsList, pageType)
        rvSms.adapter = adapter


    }

    private fun callApiToGetInfoAboutSmsUcell() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/956a206f-979e-4128-92ab-5fde7215987b"
        smsList = ArrayList<SmsPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, SmsPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        smsList.add(data)
                }

                adapter.reloadData(smsList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

    private fun callApiToGetInfoAboutSmsMobiuz() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/700fc69b-b85e-43ee-8e3e-65ebb92c2978"
        smsList = ArrayList<SmsPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, SmsPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        smsList.add(data)
                }

                adapter.reloadData(smsList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutSmsUzmobile() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/66c87526-195a-4dfb-bc1d-45ef5a8b16a2"
        smsList = ArrayList<SmsPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, SmsPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        smsList.add(data)
                }

                adapter.reloadData(smsList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

    private fun callApiToGetInfoAboutSmsBeelie() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/1c3f9499-1132-411f-b7f7-2f2ad4715883"
        smsList = ArrayList<SmsPaketInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, SmsPaketResponseModel::class.java)
                for (data in model.data) {
                    if (data.type == type)
                        smsList.add(data)
                }

                adapter.reloadData(smsList)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
}