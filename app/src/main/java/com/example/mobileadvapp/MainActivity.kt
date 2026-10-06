
package com.example.mobileadvapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileadvapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan ViewBinding dengan layout activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener tombol untuk menguji ViewBinding
        binding.btnCheckConfig.setOnClickListener {

            // Mengubah teks TextView
            binding.tvStatus.text =
                "Konfigurasi Project & ViewBinding Berhasil!"

            // Menampilkan Toast
            Toast.makeText(
                this,
                "Konfigurasi Project & ViewBinding Berhasil!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
