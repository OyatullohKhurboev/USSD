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
import com.example.ussd.adapters.TarifRejaAdapter
import com.example.ussd.model.TarifRejaInfoModel
import com.example.ussd.model.TarifRejaModel
import com.example.ussd.model.TarifRejaResponseModel
import com.google.gson.Gson

class TarifRejaFragment(val type: Int, val pageType: PageType) : Fragment() {

    private lateinit var rvTarif: RecyclerView
    private lateinit var adapter: TarifRejaAdapter
    private var tarifList = ArrayList<TarifRejaInfoModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_tarif_reja, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiToGetInfoAboutTariffs()
//        when (type) {
//            0 -> tarifNomi()
//            1 -> abonentTolovi()
//            else -> tarifNomi()
//        }


        rvTarif = view.findViewById(R.id.rv_tarif_reja)
        rvTarif.layoutManager = LinearLayoutManager(context)
        adapter = TarifRejaAdapter(requireActivity(), tarifList, pageType)
        rvTarif.adapter = adapter
    }

    private fun callApiToGetInfoAboutTariffs() {

        val queue = Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/1ac13523-0433-472a-ba21-434d83c1bb44"

        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, TarifRejaResponseModel::class.java)
                tarifList = model.data
                adapter.reloadData(tarifList)
//                Toast.makeText(context, model.data[0].abonet_tolovi, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

//    private fun abonentTolovi() {
//        tarifList.add(
//            TarifRejaModel(
//                "salom",
//                "salom",
//                "salom",
//                "salom  ",
//                "salom",
//                "salom",
//            )
//        )
//
//    }
//
//    private fun tarifNomi() {
//        tarifList.add(
//            TarifRejaModel(
//                "salom",
//                "salom",
//                "salom",
//                "salom",
//                "salom",
//                "salom",
//            )
//        )
//
//    }
}
