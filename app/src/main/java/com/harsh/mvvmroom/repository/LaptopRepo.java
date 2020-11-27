package com.harsh.mvvmroom.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.harsh.mvvmroom.model.Laptop;

import java.util.List;

public class LaptopRepo {
    private LaptopDao laptopDao;
    private LiveData<List<Laptop>> laptops;


    public LaptopRepo(Application application) {
        LaptopDatabase database = LaptopDatabase.getInstance(application);
        laptopDao = database.laptopDao();
        laptops = laptopDao.getLaptopsOrderByCostAsc();
    }

    public void insert(final Laptop laptop) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        laptopDao.insert(laptop);
                    }
                }
        ).start();

    }

    public void update(final Laptop laptop) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        laptopDao.update(laptop);
                    }
                }
        ).start();

    }

    public void delete(final Laptop laptop) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        laptopDao.delete(laptop);
                    }
                }
        ).start();

    }

    public void deleteAll() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        laptopDao.deleteAll();
                    }
                }
        ).start();

    }

    public LiveData<List<Laptop>> getLaptopsOrderByCostAsc() {
        return laptops;
    }


}
