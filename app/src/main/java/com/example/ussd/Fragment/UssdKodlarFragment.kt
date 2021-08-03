package com.example.ussd.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.R
import com.example.ussd.adapters.UssdKodlarAdapter
import com.example.ussd.model.UssdKodlarModel

class UssdKodlarFragment (val type: Int, val pageType: PageType) : Fragment() {

    private lateinit var rvUssd: RecyclerView
    private lateinit var adapter: UssdKodlarAdapter
    private var UssdList = ArrayList<UssdKodlarModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ussd_kodlar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (type) {

            1 -> Title()
            else -> Title()
        }


        rvUssd = view.findViewById(R.id.rv_ussd_kod)
        rvUssd.layoutManager = LinearLayoutManager(context)
        adapter = UssdKodlarAdapter(requireActivity(), UssdList, pageType)
        rvUssd.adapter = adapter
    }

    private fun Title() {
        val Internet1 = UssdKodlarModel(
            "SpiderMan",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        UssdList.add(Internet1)
        val Internet2 = UssdKodlarModel(
            "SpiderMan",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        UssdList.add(Internet2)
        val Internet3 = UssdKodlarModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        UssdList.add(Internet3)

    }

    }

