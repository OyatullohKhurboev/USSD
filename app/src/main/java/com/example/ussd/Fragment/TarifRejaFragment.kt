package com.example.ussd.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.R
import com.example.ussd.adapters.TarifRejaAdapter
import com.example.ussd.model.TarifRejaModel

class TarifRejaFragment(val type: Int, val pageType: PageType) : Fragment() {

    private lateinit var rvTarif: RecyclerView
    private lateinit var adapter: TarifRejaAdapter
    private var tarifList = ArrayList<TarifRejaModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tarif_reja, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (type) {
            0 -> tarifNomi()
            1 -> abonentTolovi()
            else -> tarifNomi()
        }


        rvTarif = view.findViewById(R.id.rv_tarif_reja)
        rvTarif.layoutManager = LinearLayoutManager(context)
        adapter = TarifRejaAdapter(requireActivity(), tarifList, pageType)
        rvTarif.adapter = adapter
    }

    private fun abonentTolovi() {
        tarifList.add(
            TarifRejaModel(
                "salom",
                "salom",
                "salom",
                "salom  ",
                "salom",
                "salom",
            )
        )

    }
    private fun tarifNomi() {
        tarifList.add(
            TarifRejaModel(
                "salom",
                "salom",
                "salom",
                "salom",
                "salom",
                "salom",
            )
        )

    }
}
