package com.example.ussd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.ussd.Network.NetworkInfo

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if(NetworkInfo.isInternetConnectionIsAvailable(this)) {
            Toast.makeText(this, "Yes, You have an internet access!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "No You have not internet access!", Toast.LENGTH_LONG).show()

        }

//        Handler().postDelayed({
//            val intent = Intent(this, Umumiy_diller::class.java)
//            startActivity(intent)
//            finish()
//        }, 3000)
    }
}
