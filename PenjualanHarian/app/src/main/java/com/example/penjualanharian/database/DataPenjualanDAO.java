package com.example.penjualanharian.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataPenjualanDAO {
    @Insert
    Long InsertData(DataPenjualan dataPenjualan);

    @Query("Select * from penjualan_db")
    List<DataPenjualan> getData();

    @Update
    int updateData(DataPenjualan item);

    @Delete
    void deleteData(DataPenjualan item);
}
