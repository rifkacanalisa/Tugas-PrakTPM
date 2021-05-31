package com.example.bukukas.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bukukas.R;
import com.example.bukukas.database.AppDatabase;
import com.example.bukukas.database.DataPenjualan;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.view{

    private AppDatabase appDatabase;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;

    private Button btnSubmit;
    private RecyclerView recyclerView;
    private EditText etTanggal, etPemasukan, etPengeluaran;

    private int id = 0; //id autogenerate, diitung dari 0
    boolean edit = false; //untuk on/off fitur edit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btn_submit);
        etTanggal = findViewById(R.id.et_tanggal);
        etPemasukan = findViewById(R.id.et_pemasukkan);
        etPengeluaran = findViewById(R.id.et_pengeluaran);
        recyclerView = findViewById(R.id.activitymain_rv);

        //koneksi db
        appDatabase = AppDatabase.inidb(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainPresenter = new MainPresenter(this);

        //read data
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successAdd() {
        Toast.makeText(this,"Berhasil Menambahkan Data",Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this,"Berhasil Menghapus Data",Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        etTanggal.setText("");
        etPemasukan.setText("");
        etPengeluaran.setText("");
        btnSubmit.setText("Submit");
    }

    @Override
    public void getData(List<DataPenjualan> list) {
        mainAdapter = new MainAdapter(this, list, this);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void editData(DataPenjualan item) {
        etTanggal.setText(item.getTanggal());
        etPemasukan.setText(item.getPemasukan());
        etPengeluaran.setText(item.getPengeluaran());
        id = item.getId();
        edit = true;
        btnSubmit.setText("Edit Data");
    }

    @Override
    public void deleteData(DataPenjualan item) {
        AlertDialog.Builder builder;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else{
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data").setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetForm();
                mainPresenter.deleteData(item, appDatabase);
            }
        })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .show();

    }



    @Override
    public void onClick(View v) {
        if (v == btnSubmit){
            if(etTanggal.getText().toString().equals("") || etPemasukan.getText().toString().equals("")
                    || etPengeluaran.getText().toString().equals("")){
                Toast.makeText(this,"Data tidak boleh kosong",Toast.LENGTH_SHORT).show();
            }
        } else {
            if(!edit){
                mainPresenter.insertData(etTanggal.getText().toString(), Integer.parseInt(etPemasukan.getText().toString()), Integer.parseInt(etPengeluaran.getText().toString()), appDatabase);
            } else {
                mainPresenter.editData(id, etTanggal.getText().toString(), Integer.parseInt(etPemasukan.getText().toString()), Integer.parseInt(etPengeluaran.getText().toString()), appDatabase);
                edit = false;
            }
            resetForm();
        }
    }
}