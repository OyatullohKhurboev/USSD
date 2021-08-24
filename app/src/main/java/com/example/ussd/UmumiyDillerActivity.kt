package com.example.ussd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ussd.Fragment.BoshSahifa
import com.example.ussd.Fragment.Language
import kotlinx.android.synthetic.main.activity_umumiy_diller.*


class UmumiyDillerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_umumiy_diller)
        makeCurrentFragment(BoshSahifa())

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bosh_sahifa -> makeCurrentFragment(BoshSahifa())
                R.id.til -> makeCurrentFragment(Language())
                else -> makeCurrentFragment(BoshSahifa())
            }
            true
        }


    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_menu, fragment)
            commit()
        }
}