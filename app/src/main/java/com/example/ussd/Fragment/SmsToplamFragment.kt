package com.example.ussd.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.R
import com.example.ussd.adapters.InternetPaketAdapter
import com.example.ussd.model.InternetPaketModel

class SmsToplamFragment(val type: Int, val pageType: PageType) : Fragment() {

    private lateinit var rvInternet: RecyclerView
    private lateinit var adapter: InternetPaketAdapter
    private var SmsList = ArrayList<InternetPaketModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sms_toplam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (type) {
            0 -> Name()
            1 -> Title()
            else -> Info()
        }


        rvInternet = view.findViewById(R.id.rv_sms_toplam)
        rvInternet.layoutManager = LinearLayoutManager(context)
        adapter = InternetPaketAdapter(requireActivity(), SmsList, pageType)
        rvInternet.adapter = adapter
    }

    private fun Title() {
        val Internet1 = InternetPaketModel(
            "SpiderMan",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet1)
        val Internet2 = InternetPaketModel(
            "SpiderMan",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet2)
        val Internet3 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet3)

    }

    private fun Info() {
        val Internet1 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet1)
        val Internet2 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet2)
        val Internet3 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet3)

    }

    private fun Name() {
        val Internet1 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet1)
        val Internet2 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet2)
        val Internet3 = InternetPaketModel(
            "1500 mb",

            "Narxi 420 so'm.\nAmal qilish muddati 30 kun.\nFaollashtirish: *111*2*1*1#."
        )
        SmsList.add(Internet3)


    }

}