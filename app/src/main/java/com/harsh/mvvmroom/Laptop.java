package com.harsh.mvvmroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "laptop_table")
public class Laptop {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String laptop_name;

    private String laptop_description;

    @ColumnInfo(name = "ram_size")
    private int ram;

    @ColumnInfo(name = "storage_size")
    private int storage;

    @ColumnInfo(name = "gpu_size")
    private int gpu;

    private long cost;

    public Laptop(String laptop_name, String laptop_description, int ram, int storage, int gpu, long cost) {
        this.laptop_name = laptop_name;
        this.laptop_description = laptop_description;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    //room will use this method to set id for our table rows(autogenerate)
    public void setId(int id) {
        this.id = id;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public String getLaptop_description() {
        return laptop_description;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public int getGpu() {
        return gpu;
    }

    public long getCost() {
        return cost;
    }

    @NonNull
    @Override
    public String toString() {
        String laptop = "Name:" + getLaptop_name() + "\n" +
                "Description:" + getLaptop_description() + "\n" +
                "RAM:" + getRam() + "\n" +
                "Storage:" + getStorage() + "\n" +
                "GPU:" + getGpu() + "\n" +
                "Cost:" + getCost() + "\n";

        return laptop;

    }
}
