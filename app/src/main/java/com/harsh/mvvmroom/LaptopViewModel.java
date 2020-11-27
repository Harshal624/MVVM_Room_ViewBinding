package com.harsh.mvvmroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LaptopViewModel extends AndroidViewModel {
    private LaptopRepo repo;
    private LiveData<List<Laptop>> laptops;

    public LaptopViewModel(@NonNull Application application) {
        super(application);
        repo = new LaptopRepo(application);
    }

    public void insert(Laptop laptop) {
        repo.insert(laptop);
    }

    public void update(Laptop laptop) {
        repo.update(laptop);
    }

    public void delete(Laptop laptop) {
        repo.delete(laptop);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public LiveData<List<Laptop>> getLaptops() {
        return repo.getLaptopsOrderByCostAsc();
    }
}
