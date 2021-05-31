package com.example.penjualanharian.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.penjualanharian.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahDataActivity extends AppCompatActivity {

    private EditText etPemasukan, etPengeluaran, etTanggal;
    private Button btnTambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        etPemasukan = findViewById(R.id.et_pemasukkan);
        etPengeluaran = findViewById(R.id.et_pengeluaran);
        etTanggal = findViewById(R.id.et_tanggal);
        btnTambah = findViewById(R.id.btn_tambah);


    }


//    @Override
//    public void successAdd() {
//        Toast.makeText(this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
//        Intent pindah = new Intent(this, MainActivity.class);
//        startActivity(pindah);
//    }
}