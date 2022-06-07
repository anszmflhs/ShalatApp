package com.example.shalatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.shalatapp.databinding.ActivityDetailBinding
import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    companion object {
        const val Detail_Data = "A"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<BatalShalatItem>(Detail_Data)

        binding.txtJudulDetail.text = data?.judul
        binding.txtDeskDetail.text = data?.deskripsi
        Glide.with(this).load(data?.gambar).into(binding.imgDetail)
    }
}