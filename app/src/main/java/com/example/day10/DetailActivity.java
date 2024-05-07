package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Terima data dari Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Ambil nilai dari intent extra dengan kunci "nota"
            String nota = extras.getString("nota");

            // Pastikan nilai nota tidak null sebelum digunakan
            if (nota != null) {
                // Pisahkan nilai nota menjadi beberapa bagian berdasarkan baris
                String[] parts = nota.split("\n");

                // Pastikan array parts memiliki cukup banyak elemen
                if (parts.length >= 6) {
                    // Inisialisasi TextView untuk menampilkan data
                    TextView tvCarTypeValue = findViewById(R.id.tvCarTypeValue);
                    TextView tvCityTypeValue = findViewById(R.id.tvCityTypeValue);
                    TextView tvDayOfRentValue = findViewById(R.id.tvDayOfRentValue);
                    TextView tvDiscountValue = findViewById(R.id.tvDiscountValue);
                    TextView tvTotalValue = findViewById(R.id.tvTotalValue);

                    // Set nilai TextView berdasarkan bagian nota yang sesuai
                    tvCarTypeValue.setText(parts[1].substring(parts[1].indexOf(":") + 1).trim());
                    tvCityTypeValue.setText(parts[2].substring(parts[2].indexOf(":") + 1).trim());
                    tvDayOfRentValue.setText(parts[3].substring(parts[3].indexOf(":") + 1).trim());
                    tvDiscountValue.setText(parts[4].substring(parts[4].indexOf(":") + 1).trim());
                    tvTotalValue.setText(parts[5].substring(parts[5].indexOf(":") + 1).trim());
                } else {
                    // Jika array parts tidak memiliki elemen yang cukup, tampilkan pesan kesalahan
                    Toast.makeText(this, "Invalid data format", Toast.LENGTH_SHORT).show();
                    // Tutup aktivitas DetailActivity
                    finish();
                }
            } else {
                // Jika nota bernilai null, tampilkan pesan kesalahan dan tutup aktivitas
                Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            // Jika tidak ada data yang diterima, tampilkan pesan kesalahan dan tutup aktivitas
            Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
