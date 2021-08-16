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
import com.example.ussd.adapters.DaqiqaAdapter
import com.example.ussd.adapters.TarifRejaAdapter
import com.example.ussd.model.DaqiqaInfoModel
import com.example.ussd.model.DaqiqaResponseModel
import com.example.ussd.model.TarifRejaInfoModel
import com.example.ussd.model.TarifRejaResponseModel
import com.google.gson.Gson


class DaqiqaFragment(val type: String, val pageType: PageType) : Fragment() {

    private lateinit var rvDaqiqa: RecyclerView
    private lateinit var adapter: DaqiqaAdapter
    private var daqiqaList = ArrayList<DaqiqaInfoModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_daqiqa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiToGetInfoAboutTariffs()



        rvDaqiqa = view.findViewById(R.id.rv_fragment_daqiqa)
        rvDaqiqa.layoutManager = LinearLayoutManager(context)
        adapter = DaqiqaAdapter(requireActivity(), daqiqaList, pageType)
        rvDaqiqa.adapter = adapter
    }

    private fun callApiToGetInfoAboutTariffs() {

        val queue =   Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/1c7dd753-7b56-4161-9461-65fcc194d828"
        daqiqaList = ArrayList<DaqiqaInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, DaqiqaResponseModel::class.java)
                for(data in model.data) {
                    if (data.type == type)
                        daqiqaList.add(data)
                }

                adapter.reloadData(daqiqaList)
//                Toast.makeText(context, model.data[0].abonet_tolovi, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

}
