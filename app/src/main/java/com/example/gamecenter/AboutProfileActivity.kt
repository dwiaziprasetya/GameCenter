package com.example.gamecenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class AboutProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_profile)

        val btnSetting : ImageButton = findViewById(R.id.imageButton4)
        val btnEditProfile : Button = findViewById(R.id.appCompatButton)
        val btnFavourites : Button = findViewById(R.id.appCompatButton2)
        val btnYourGame : Button = findViewById(R.id.appCompatButton3)
        val btnCart : Button = findViewById(R.id.appCompatButton4)
        val btnBalanceWallet : Button = findViewById(R.id.appCompatButton5)
        val btnFriends : Button = findViewById(R.id.appCompatButton6)
        val btnLogOut : Button = findViewById(R.id.btn_log_out)
        val btnBackAbout : ImageButton = findViewById(R.id.btn_back_about)


        btnSetting.setOnClickListener(this)
        btnEditProfile.setOnClickListener(this)
        btnFavourites.setOnClickListener(this)
        btnYourGame.setOnClickListener(this)
        btnCart.setOnClickListener(this)
        btnBalanceWallet.setOnClickListener(this)
        btnFriends.setOnClickListener(this)
        btnLogOut.setOnClickListener(this)

        btnBackAbout.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imageButton4 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.appCompatButton -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.appCompatButton2 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.appCompatButton3 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.appCompatButton4 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.appCompatButton5 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.appCompatButton6 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_log_out -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
        }
    }
}