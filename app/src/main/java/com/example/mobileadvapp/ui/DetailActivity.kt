package com.example.mobileadvapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileadvapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan ViewBinding dengan activity_detail.xml
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menerima data dari MainActivity
        val name = intent.getStringExtra("EXTRA_NAME") ?: "-"
        val nim = intent.getStringExtra("EXTRA_NIM") ?: "-"
        val prodi = intent.getStringExtra("EXTRA_PRODI") ?: "-"
        val score = intent.getIntExtra("EXTRA_SCORE", 0)

        // Menampilkan data
        binding.tvDetailInfo.text = """
            Nama           : $name
            NIM            : $nim
            Program Studi  : $prodi
            Counter        : $score
        """.trimIndent()

        binding.btnDialPhone.setOnClickListener {

            val phoneNumber = "62895380206438"

            val whatsappIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    "https://wa.me/$phoneNumber"
                )
            )

            startActivity(whatsappIntent)
        }

        // Membuka lokasi kampus di Maps
        binding.btnOpenMap.setOnClickListener {

            val mapUri = Uri.parse(
                "geo:-7.7599,110.4083?q=Universitas+AMIKOM+Yogyakarta"
            )

            val mapIntent = Intent(
                Intent.ACTION_VIEW,
                mapUri
            )

            startActivity(mapIntent)
        }

        // Membuka website kampus
        binding.btnOpenWebsite.setOnClickListener {

            val websiteUri = Uri.parse(
                "https://amikom.ac.id"
            )

            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                websiteUri
            )

            startActivity(browserIntent)
        }
    }
}

