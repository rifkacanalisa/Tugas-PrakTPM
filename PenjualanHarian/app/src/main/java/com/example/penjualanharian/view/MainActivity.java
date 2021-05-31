package com.example.penjualanharian.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.penjualanharian.R;
import com.example.penjualanharian.database.AppDatabase;
import com.example.penjualanharian.database.DataPenjualan;
import com.example.penjualanharian.database.DataPenjualanDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private List<DataPenjualan> list;
    private MainPresenter mainPresenter;
    private DataPenjualanDAO penjualanDAO;
    private MainAdapter mainAdapter;

    private FloatingActionButton fab_tambah;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_tambah = findViewById(R.id.fab_tambah);
        fab_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TambahDataActivity.class);
                startActivity(intent);
            }
        });

        appDatabase = AppDatabase.inidb(getApplicationContext());

        recyclerView = findViewById(R.id.activitymain_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter.readData(appDatabase);

    }

}