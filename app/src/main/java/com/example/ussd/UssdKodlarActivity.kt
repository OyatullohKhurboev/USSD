package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.ussd.Fragment.PageType
import com.example.ussd.TabLayout.TablayoutAdapterSmsToplam
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_mb_paket_.*
import kotlinx.android.synthetic.main.activity_sms_paket.*
import kotlinx.android.synthetic.main.activity_ussd_kodlar.*

class UssdKodlarActivity : AppCompatActivity() {
   lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ussd_kodlar)
        setSupportActionBar(toolbar_ussd)
        supportActionBar?.apply {
            title = "USSD kodlar"


        }
        val pageType: PageType = intent.getSerializableExtra("dillerType") as PageType





        viewPager = findViewById(R.id.viewPager_ussd)



        when (pageType) {
            PageType.Mobiuz -> {

                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.mobiuz)

            }
            PageType.Ucell -> {
                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.ucell)

            }
            PageType.Beeline -> {
                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.beeline)


            }
            PageType.Uzmobile -> {
                toolbar_ussd.background = ContextCompat.getDrawable(this, R.color.uzmobile)

                }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}