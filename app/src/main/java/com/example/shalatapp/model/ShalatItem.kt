package com.example.shalatapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShalatItem(
    @Json(name = "judul")
    var title: String = "",
    var data: List<DalilShalatItem> = arrayListOf()
) : Parcelable

@Parcelize
data class DalilShalatItem (
    var id : Int = 0,
    @Json(name = "gambar") // Dari Firebase
    var gambar : String?, // Dari Variable
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "deskripsi")
    var deskripsi : String?,
) : Parcelable

@Parcelize
data class BatalShalatItem (
    var id : Int = 0,
    @Json(name = "gambar") // Dari Firebase
    var gambar : String?, // Dari Variable
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "deskripsi")
    var deskripsi : String?,
) : Parcelable