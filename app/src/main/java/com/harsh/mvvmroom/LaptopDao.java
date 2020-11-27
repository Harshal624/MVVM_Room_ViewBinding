package com.harsh.mvvmroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LaptopDao {

    @Insert
    void insert(Laptop laptop);

    @Update
    void update(Laptop laptop);

    @Delete
    void delete(Laptop laptop);

    @Query("DELETE FROM LAPTOP_TABLE")
    void deleteAll();

    @Query("SELECT * FROM LAPTOP_TABLE ORDER BY cost ASC")
    LiveData<List<Laptop>> getLaptopsOrderByCostAsc();

    @Query("SELECT * FROM LAPTOP_TABLE ORDER BY cost DESC")
    LiveData<List<Laptop>> getLaptopsOrderByCostDesc();


}
