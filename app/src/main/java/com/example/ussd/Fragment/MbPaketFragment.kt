package com.example.ussd.Fragment

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
        callApiToGetInfoAboutMb()


        rvInternet = view.findViewById(R.id.rvMbPAket)
        rvInternet.layoutManager = LinearLayoutManager(context)
        adapter = InternetPaketAdapter(requireActivity(), internetList, pageType)
        rvInternet.adapter = adapter
        callApiToGetInfoAboutMb()
    }

    private fun callApiToGetInfoAboutMb() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/ed409846-af25-4067-bdd4-82b130448f45"
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
}