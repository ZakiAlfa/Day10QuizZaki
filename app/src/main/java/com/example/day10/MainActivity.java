package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etTotal;
    private Button btRent;
    private RadioGroup radioGroup, rgCity;
    private RadioButton rbPajero, rbAlphard, rbInova, rbBrio, rbInside, rbOutside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTotal = findViewById(R.id.etTotal);
        btRent = findViewById(R.id.btRent);
        radioGroup = findViewById(R.id.radioGroup);
        rgCity = findViewById(R.id.rgCity);
        rbPajero = findViewById(R.id.rbPajero);
        rbAlphard = findViewById(R.id.rbAlphard);
        rbInova = findViewById(R.id.rbInova);
        rbBrio = findViewById(R.id.rbBrio);
        rbInside = findViewById(R.id.rbInside);
        rbOutside = findViewById(R.id.rbOutside);

        btRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalHarga = 0;
                String selectedCarType = "";
                String cityType = "";
                int dayOfRent = 0;

                if (rbPajero.isChecked()) {
                    totalHarga += 2400000;
                    selectedCarType = "Pajero";
                } else if (rbAlphard.isChecked()) {
                    totalHarga += 1550000;
                    selectedCarType = "Alphard";
                } else if (rbInova.isChecked()) {
                    totalHarga += 850000;
                    selectedCarType = "Inova";
                } else if (rbBrio.isChecked()) {
                    totalHarga += 550000;
                    selectedCarType = "Brio";
                }

                int biayaLuarKota = rbInside.isChecked() ? 135000 : 250000;
                totalHarga += biayaLuarKota;
                cityType = rbInside.isChecked() ? "Inside City" : "Outside City";

                try {
                    dayOfRent = Integer.parseInt(etTotal.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter valid number of days", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Menampilkan bon sebagai pesan toast
                String bonMessage = "Bon:\n";
                bonMessage += "Selected Car Type: " + selectedCarType + " - " + totalHarga + "\n";
                bonMessage += "City Type: " + cityType + "\n";
                bonMessage += "Day of Rent: " + dayOfRent + "\n";
                bonMessage += "Total Harga: " + totalHarga * dayOfRent + "\n";
                Toast.makeText(MainActivity.this, bonMessage, Toast.LENGTH_LONG).show();

                // Pindah ke DetailActivity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("totalHarga", totalHarga);
                intent.putExtra("selectedCarType", selectedCarType);
                intent.putExtra("cityType", cityType);
                intent.putExtra("dayOfRent", dayOfRent);
                startActivity(intent);
            }
        });
    }

    public void checkButton(View v) {
        RadioGroup rg = findViewById(R.id.radioGroup);
        int radioId = rg.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioId);
        Toast.makeText(this, "Silahkan memilih Mobil: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
