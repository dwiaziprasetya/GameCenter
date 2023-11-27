package com.example.gamecenter

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvGames : RecyclerView
    private val list = ArrayList<Games>()

    companion object {
        const val KEY = "Intent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val btnNotification : ImageButton = findViewById(R.id.imageButton3)
        val btnAbout : ImageButton = findViewById(R.id.btn_about_profile)

        rvGames = findViewById(R.id.rv_games)
        rvGames.setHasFixedSize(true)

        list.addAll(getListGames())
        showRecyclerList()
        btnNotification.setOnClickListener(this)
        btnAbout.setOnClickListener(this)
    }

    private fun setRecyclerViewLayoutManager(orientation : Int){
        when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                rvGames.layoutManager = LinearLayoutManager(this)
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                rvGames.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            }
        }
    }

    @SuppressLint("Recycle")
    private fun getListGames(): ArrayList<Games> {
        val dataName = resources.getStringArray(R.array.data_game)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDetailPhoto = resources.obtainTypedArray(R.array.data_detail_photo)
        val dataDownloads = resources.getStringArray(R.array.data_downloads)
        val dataRatingAge = resources.getStringArray(R.array.data_rating_age)
        val dataReviews = resources.getStringArray(R.array.data_reviews)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val listGame = ArrayList<Games>()
        for (i in dataName.indices){
            val game = Games(dataName[i],
                                dataGenre[i],
                                    dataPrice[i],
                                        dataPhoto.getResourceId(i, -1),
                                            dataDetailPhoto.getResourceId(i, 0),
                                                dataDownloads[i],
                                                    dataRatingAge[i],
                                                        dataReviews[i],
                                                            dataDescription[i])
            listGame.add(game)
        }
        return listGame
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setRecyclerViewLayoutManager(newConfig.orientation)
    }

    private fun showRecyclerList(){
        setRecyclerViewLayoutManager(resources.configuration.orientation)
        val listGameAdapter = ListGameAdapter(list)
        rvGames.adapter = listGameAdapter
        listGameAdapter.setOnItemClickCallback(object : ListGameAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Games) {
                val intent = Intent(this@MainActivity, ItemDetailActivity::class.java)
                intent.putExtra(KEY, data)
                startActivity(intent)
            }
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_about_profile -> {
                val moveIntent = Intent(this@MainActivity, AboutProfileActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.imageButton3 -> {
                Toast.makeText(this,"Developer has not updated this feature", Toast.LENGTH_SHORT).show()
            }
        }
    }
}