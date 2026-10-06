package com.example.mobileadvapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileadvapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var counter = 0

    private val TAG = "LifecycleApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan ViewBinding dengan activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate Dipanggil")

        // Memulihkan counter setelah Activity dibuat kembali
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("KEY_COUNTER", 0)
        }

        binding.tvCounter.text = counter.toString()

        // Tombol tambah counter
        binding.btnIncrement.setOnClickListener {
            counter++
            binding.tvCounter.text = counter.toString()
        }

        // Explicit Intent menuju DetailActivity
        binding.btnSendData.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val nim = binding.etNim.text.toString().trim()
            val prodi = binding.etProdi.text.toString().trim()

            if (name.isEmpty() || nim.isEmpty() || prodi.isEmpty()) {

                Toast.makeText(
                    this,
                    "Lengkapi semua data terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val intent = Intent(
                this,
                DetailActivity::class.java
            ).apply {

                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_NIM", nim)
                putExtra("EXTRA_PRODI", prodi)
                putExtra("EXTRA_SCORE", counter)
            }

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart Dipanggil")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume Dipanggil")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause Dipanggil")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop Dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy Dipanggil")
    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)

        outState.putInt(
            "KEY_COUNTER",
            counter
        )

        Log.d(
            TAG,
            "onSaveInstanceState Dipanggil - Counter Disimpan: $counter"
        )
    }
}

