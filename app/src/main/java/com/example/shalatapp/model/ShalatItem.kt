package com.example.shalatapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "item")
@Parcelize
data class BatalShalatItem (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @Json(name = "gambar") // Dari Firebase
    var gambar : String?, // Dari Variable
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "deskripsi")
    var deskripsi : String?,
    var type : String?
) : Parcelable

//@Entity(tableName = "items")
@Parcelize
data class DalilShalatItem (
//    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @Json(name = "gambar") // Dari Firebase
    var gambar : String?, // Dari Variable
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "deskripsi")
    var deskripsi : String?,
//    var type : String?
) : Parcelable

@Parcelize
data class ShalatItem(
    @Json(name = "judul")
    var title: String = "",
    var data: List<BatalShalatItem> = arrayListOf(),
) : Parcelable
