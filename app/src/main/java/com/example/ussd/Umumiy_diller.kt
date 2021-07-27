package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ussd.Fragment_uzmobile.Bosh_sahifa
import com.example.ussd.Language as Language

class Umumiy_diller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_umumiy_diller)
        makeCurrentFragment(Bosh_sahifa())



    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_menu, fragment)
            commit()


}}