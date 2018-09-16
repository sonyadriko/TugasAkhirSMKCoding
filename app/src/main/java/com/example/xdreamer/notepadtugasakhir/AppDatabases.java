package com.example.xdreamer.notepadtugasakhir;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {CatatanModel.class}, version = 1)
public abstract class AppDatabases extends RoomDatabase {

    public abstract CatatanDao catatanModelDao();
}
