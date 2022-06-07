package com.example.shalatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.shalatapp.databinding.ActivityDetailDalilBinding
import com.example.shalatapp.model.DalilShalatItem

class DetailActivityDalil : AppCompatActivity() {

    private lateinit var binding : ActivityDetailDalilBinding

    companion object {
        const val DETAIL = "B"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDalilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DalilShalatItem>(DETAIL)

        binding.txtJudulDetaildalil.text = data?.judul
        binding.txtDeskDetaildalil.text = data?.deskripsi
        Glide.with(this).load(data?.gambar).into(binding.imgDetaildalil)
    }
}