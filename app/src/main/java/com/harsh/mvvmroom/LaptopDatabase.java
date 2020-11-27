package com.harsh.mvvmroom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(version = 1, entities = {Laptop.class})
public abstract class LaptopDatabase extends RoomDatabase {

    private static LaptopDatabase instance;
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            final LaptopDao dao = instance.laptopDao();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    dao.insert(new Laptop("Dell XPS 13", " The best laptop you can buy in 2020"
                            , 16, 2, 8, 60000));

                    dao.insert(new Laptop("HP Envy x360 (", " The best laptop for programmers"
                            , 32, 4, 8, 80000));
                }
            }).start();

        }
    };

    public static synchronized LaptopDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LaptopDatabase.class, "laptop_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        return instance;
    }

    public abstract LaptopDao laptopDao();

}
