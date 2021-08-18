package com.example.ussd.Fragment


import android.app.Dialog
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
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.ussd.*

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
    var isChecked = false

    private var loadingDialog: Dialog? = null
    private var arrayList: ArrayList<GridViewModel>? = null
    private var gridView: GridView? = null

    private var gridViewAdapters: GridViewAdapter? = null
    var imageArray: ArrayList<Int> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_bosh_sahifa, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// lottie animation
//
//        var checkAnim = view.findViewById < LottieAnimationView >(R.id.lottie_animation)
//        checkAnim.setOnClickListener {
//            val intent = Intent(context, BoshSahifa::class.java)
//            startActivity(intent)
//            showLoading()
//            if (isChecked) {
//                checkAnim.speed = -1f
//                checkAnim.playAnimation()
//                isChecked = false
//            } else {
//                checkAnim.speed = 1f
//                checkAnim.playAnimation()
//                isChecked = true
//            }
//
//        }
// lottie end


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
                0 -> goToTablayoutSmsToplam()

                1 -> goToTablayoutMbPaket()

                2 -> goToTablayoutTarifReja()

                3 -> goToTablayoutDaqiqa()

                4 -> goToTablayoutUssdKodlar()

                5 -> goToTablayoutSevice()

            }
        }


                carouselView.pageCount = imageArray.size
                        carouselView . setImageListener (imageListener)


                        cv_ucell . setOnClickListener {
                    pageType = PageType.Ucell
                    gridViewAdapters?.updateColor(R.color.ucell)
                    cv_top_mb.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.ucell
                        )
                    )
                }

                        cv_beeline . setOnClickListener {
                    pageType = PageType.Beeline
                    gridViewAdapters?.updateColor(R.color.beeline)
                    cv_top_mb.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.beeline
                        )
                    )
                }

                        cv_uzmobile . setOnClickListener {
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

                        cv_mobiuz . setOnClickListener {
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


    private fun goToTablayoutMbPaket() {
        val intent = Intent(context, MbPaketActivity::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }

    private fun goToTablayoutUssdKodlar() {
        val intent = Intent(context, UssdKodlarActivity::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }
    private fun goToTablayoutSevice() {
        val intent = Intent(context, XizmatlarActivity::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }

    private fun goToTablayoutTarifReja() {
        val intent = Intent(context, TarifRejaActivity::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }
    private fun goToTablayoutDaqiqa() {
        val intent = Intent(context, DaqiqaActivity::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }

    private fun goToTablayoutSmsToplam() {
        val intent = Intent(context, SmsToplamActivity::class.java)
        intent.putExtra("dillerType", pageType)
        activity?.startActivity(intent)
    }

    private val imageListener = ImageListener { position, imageView ->
        imageView.setImageResource(imageArray[position])
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items: GridViewModel = arrayList!!.get(position)

    }

//
//    fun showLoading() {
//        Hideloading()
//        loadingDialog = BaseAnimation.showLoadingAnimation(requireContext())
//    }
//
//    fun Hideloading() {
//        loadingDialog.let { if (it?.isShowing == true) it?.cancel() }
//    }

}