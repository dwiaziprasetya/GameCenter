package com.example.gamecenter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val name: String,
    val genre: String,
    val price: String,
    val photo: Int,
    val detailPhoto : Int,
    val downloads : String,
    val ratingAge : String,
    val reviews : String,
    val description : String
):Parcelable
