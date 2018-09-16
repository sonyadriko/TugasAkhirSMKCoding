package com.example.xdreamer.notepadtugasakhir;

import android.app.Application;
import android.arch.persistence.room.Room;

public class MyApp extends Application {
    public static AppDatabases db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabases.class, "catatan.db").allowMainThreadQueries().build();
    }
}
