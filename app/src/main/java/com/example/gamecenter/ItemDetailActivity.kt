package com.example.gamecenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ItemDetailActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var photo : ImageView
    private lateinit var name : TextView
    private lateinit var price : TextView
    private lateinit var genre : TextView
    private lateinit var downloads : TextView
    private lateinit var ratingAge : TextView
    private lateinit var reviews : TextView
    private lateinit var description : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val games = intent.getParcelableExtra<Games>(MainActivity.KEY)

        photo = findViewById(R.id.img_detail_item_photo)
        name = findViewById(R.id.tv_detail_item_name)
        price = findViewById(R.id.tv_detail_item_price)
        genre = findViewById(R.id.tv_detail_item_genre)
        downloads = findViewById(R.id.tv_downloads)
        ratingAge = findViewById(R.id.tv_rating_age)
        reviews = findViewById(R.id.tv_reviews)
        description = findViewById(R.id.tv_description)

        val buttonBuyNow : Button = findViewById(R.id.button2)
        val buttonAddtoCart : ImageButton = findViewById(R.id.btn_img_add_to_cart)
        val buttonBack : ImageButton = findViewById(R.id.btn_back)
        val buttonShare : ImageButton = findViewById(R.id.btn_share)

        val urlSample = "https://www.dicoding.com/"

        buttonBuyNow.setOnClickListener(this)
        buttonAddtoCart.setOnClickListener(this)

        buttonShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, urlSample)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, null))
        }


        buttonBack.setOnClickListener {
            onBackPressed()
        }

        if (games != null) {
            setData(games)
        }
    }

    private fun setData(games : Games){
        photo.setImageResource(games.detailPhoto)
        name.text = games.name
        genre.text = games.genre
        downloads.text = games.downloads
        ratingAge.text = games.ratingAge
        reviews.text = games.reviews
        description.text = games.description
        price.text = games.price
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.button2 -> {
                Toast.makeText(this,"Developer has not updated this feature",Toast.LENGTH_SHORT).show()
            }
            R.id.btn_img_add_to_cart -> {
                Toast.makeText(this,"Developer has not updated this feature",Toast.LENGTH_SHORT).show()
            }
        }
    }

}