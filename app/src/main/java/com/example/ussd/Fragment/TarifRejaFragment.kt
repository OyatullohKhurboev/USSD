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
import com.example.ussd.model.TarifRejaResponseModel
import com.google.gson.Gson

class TarifRejaFragment(val type: String, val pageType: PageType) : Fragment() {

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

        when(pageType){
            PageType.Ucell ->callApiToGetInfoAboutTariffsUcell()
            PageType.Beeline -> callApiToGetInfoAboutTariffsBeeline()
            PageType.Mobiuz -> callApiToGetInfoAboutTariffsMobiuz()
            PageType.Uzmobile -> callApiToGetInfoAboutTariffsUzmobile()

        }


        rvTarif = view.findViewById(R.id.rv_tarif_reja)
        rvTarif.layoutManager = LinearLayoutManager(context)
        adapter = TarifRejaAdapter(requireActivity(), tarifList, pageType)
        rvTarif.adapter = adapter
    }

    private fun callApiToGetInfoAboutTariffsUcell() {

        val queue =   Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/ac14c145-f534-4fea-b346-bbc3aeb0f41c"
        tarifList = ArrayList<TarifRejaInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, TarifRejaResponseModel::class.java)
                for(data in model.data) {
                    if (data.type == type)
                        tarifList.add(data)
                }

                adapter.reloadData(tarifList)
//                Toast.makeText(context, model.data[0].abonet_tolovi, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutTariffsBeeline() {

        val queue =   Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/1139f781-45ae-4d8e-9a80-8c010ca4d458"
        tarifList = ArrayList<TarifRejaInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, TarifRejaResponseModel::class.java)
                for(data in model.data) {
                    if (data.type == type)
                        tarifList.add(data)
                }

                adapter.reloadData(tarifList)
//                Toast.makeText(context, model.data[0].abonet_tolovi, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutTariffsMobiuz() {

        val queue =   Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/b9bb3d94-81b8-4e19-a41d-df8ddb294ebe"
        tarifList = ArrayList<TarifRejaInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, TarifRejaResponseModel::class.java)
                for(data in model.data) {
                    if (data.type == type)
                        tarifList.add(data)
                }

                adapter.reloadData(tarifList)
//                Toast.makeText(context, model.data[0].abonet_tolovi, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }
    private fun callApiToGetInfoAboutTariffsUzmobile() {

        val queue =   Volley.newRequestQueue(context)

        val url = "https://run.mocky.io/v3/f6d0cd70-ecfd-4afd-8ad6-2790884e60b8"
        tarifList = ArrayList<TarifRejaInfoModel>()
        val request = object : StringRequest(Request.Method.GET, url,
            Response.Listener { result ->
                val model = Gson().fromJson(result, TarifRejaResponseModel::class.java)
                for(data in model.data) {
                    if (data.type == type)
                        tarifList.add(data)
                }

                adapter.reloadData(tarifList)
//                Toast.makeText(context, model.data[0].abonet_tolovi, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }) {}

        queue.add(request)

    }

}
