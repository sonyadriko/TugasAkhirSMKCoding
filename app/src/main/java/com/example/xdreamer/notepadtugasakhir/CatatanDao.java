package com.example.xdreamer.notepadtugasakhir;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CatatanDao {

    @Query("SELECT*FROM CatatanModel ORDER BY id DESC")
    List<CatatanModel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CatatanModel catatanModels);

    @Delete
    void deleteUsers(CatatanModel catatanModel);

    @Update
    void update(CatatanModel catatanModel);
}
