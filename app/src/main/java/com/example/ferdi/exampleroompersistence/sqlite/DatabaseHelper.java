package com.example.ferdi.exampleroompersistence.sqlite;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;
import com.example.ferdi.exampleroompersistence.sqlite.dao.MahasiswaDao;

/**
 * Created by ferdi on 8/3/2018.
 */

@Database(entities = {Mahasiswa.class},version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    public abstract MahasiswaDao mahasiswaDao();
}