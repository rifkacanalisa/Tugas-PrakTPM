package com.example.bukukas.view;

import android.view.View;

import com.example.bukukas.database.AppDatabase;
import com.example.bukukas.database.DataPenjualan;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void getData(List<DataPenjualan> list);
        void editData(DataPenjualan item);
        void deleteData(DataPenjualan item);
        void resetForm();
    }

    interface presenter {
        void insertData(String tanggal, int pemasukan, int pengeluaran, AppDatabase database);
        void readData(AppDatabase database);
        void editData(int id, String tanggal, int pemasukan, int pengeluaran, AppDatabase database);
        void deleteData(DataPenjualan dataPenjualan, AppDatabase database);
    }
}

