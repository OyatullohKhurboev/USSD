package com.example.ussd.Fragment


import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import androidx.core.content.ContextCompat
import com.example.ussd.R
import com.example.ussd.MbPaketUmumiy
import com.example.ussd.TarifReja

import com.example.ussd.adapters.GridViewAdapter
import com.example.ussd.model.GridViewModel
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_bosh_sahifa.*

enum class PageType {
    Ucell,
    Uzmobile,
    Beeline,
    Mobiuz
}


class BoshSahifa : Fragment(), AdapterView.OnItemClickListener {

    var pageType: PageType = PageType.Uzmobile


    private var arrayList: ArrayList<GridViewModel>? = null
    private var gridView: GridView? = null

    private var gridViewAdapters: GridViewAdapter? = null
    var imageArray: ArrayList<Int> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bosh_sahifa, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridView = view.findViewById(R.id.grid_view)
        arrayList = ArrayList()
        arrayList = setDataList()

        gridViewAdapters = GridViewAdapter(view.context, arrayList!!, R.color.uzmobile)
        gridView?.adapter = gridViewAdapters
        cv_ucell.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                outlineAmbientShadowColor = Color.WHITE
                outlineSpotShadowColor = Color.BLUE
            }
        }
        cv_beeline.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                outlineAmbientShadowColor = Color.WHITE
                outlineSpotShadowColor = Color.YELLOW
            }
        }
        cv_mobiuz.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                outlineAmbientShadowColor = Color.WHITE
                outlineSpotShadowColor = Color.RED
            }
        }
        cv_uzmobile.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                outlineAmbientShadowColor = Color.WHITE
                outlineSpotShadowColor = Color.BLUE
            }
        }
        cv_top_mb.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                outlineAmbientShadowColor = Color.WHITE
                outlineSpotShadowColor = Color.DKGRAY
            }
        }


        gridView?.onItemClickListener = this
        imageArray.add(R.drawable.chiroyli_raqam)
        imageArray.add(R.drawable.zor_beeline)
        imageArray.add(R.drawable.mobi25)
        imageArray.add(R.drawable.al_chiroq)
        gridView?.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                1 -> goToTablayoutMb()
                5 -> goToTablayoutTarifReja()

            }

        }



        carouselView.pageCount = imageArray.size
        carouselView.setImageListener(imageListener)


        cv_ucell.setOnClickListener {
            pageType = PageType.Ucell
            gridViewAdapters?.updateColor(R.color.ucell)
            cv_top_mb.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.ucell
                )
            )
        }

        cv_beeline.setOnClickListener {
            pageType = PageType.Beeline
            gridViewAdapters?.updateColor(R.color.beeline)
            cv_top_mb.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.beeline
                )
            )
        }

        cv_uzmobile.setOnClickListener {
            pageType = PageType.Uzmobile
            gridViewAdapters?.updateColor(R.color.uzmobile)
            imageArray.add(R.drawable.uzmobile_logo)
            cv_top_mb.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.uzmobile
                )
            )
        }

        cv_mobiuz.setOnClickListener {
            pageType = PageType.Mobiuz
            gridViewAdapters?.updateColor(R.color.mobiuz)
            cv_top_mb.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.mobiuz
                )
            )
        }

    }


    private fun setDataList(): ArrayList<GridViewModel> {

        val arrayList: ArrayList<GridViewModel> = ArrayList()

        arrayList.add(GridViewModel(R.drawable.icon_sms_paket, "SMS To'plamlar"))
        arrayList.add(GridViewModel(R.drawable.icon_mb_paket, "Internet Paketlar"))
        arrayList.add(GridViewModel(R.drawable.icon_tarif_reja, "Tarif Rejalar"))
        arrayList.add(GridViewModel(R.drawable.icon_daqiqa_minut, "Daqiqa Minutlar"))
        arrayList.add(GridViewModel(R.drawable.icon_ussd_code, "USSD ko'dlar"))
        arrayList.add(GridViewModel(R.drawable.icon_xizmatlar, "Xizmatlar"))
        return arrayList
    }


    private fun goToTablayoutMb() {
        val intent = Intent(context, MbPaketUmumiy::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }

    private fun goToTablayoutTarifReja() {
        val intent = Intent(context, TarifReja::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }

    private val imageListener = ImageListener { position, imageView ->
        imageView.setImageResource(imageArray[position])
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items: GridViewModel = arrayList!!.get(position)

    }


}