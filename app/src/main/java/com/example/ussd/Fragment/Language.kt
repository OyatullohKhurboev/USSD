package com.example.ussd.Fragment

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ussd.R
import kotlinx.android.synthetic.main.fragment_language.*
import android.util.DisplayMetrics
import java.util.*


class Language : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_lang_ru.setOnClickListener {
            val language_ru = "ru"

                tv_lang_en.setOnClickListener {
                    val language_en = "en"


                    val res: Resources = requireContext().resources

                    val dm: DisplayMetrics = res.getDisplayMetrics()

                    val conf: Configuration = res.getConfiguration()

                    conf.setLocale(Locale(language_ru.toLowerCase()))

                    conf.setLocale(Locale(language_en.toLowerCase()))

                    res.updateConfiguration(conf, dm)
                }

                tv_lang_uz.setOnClickListener {

                }


            }
        }}