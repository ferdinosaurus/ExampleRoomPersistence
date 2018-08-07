package com.example.ferdi.exampleroompersistence.sqlite.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;

import java.util.List;

/**
 * Created by ferdi on 8/3/2018.
 */
@Dao
public interface MahasiswaDao {

    @Insert
    long insertOnlySingleMahasiswa(Mahasiswa mahasiswa);

    @Insert
    void insertMultipleMahasiswa(List<Mahasiswa> mahasiswaList);

    @Query("SELECT * FROM mahasiswa WHERE id = :id")
    Mahasiswa getMahasiswaById(int id);

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Delete
    void delete(Mahasiswa mahasiswa);

    @Query("UPDATE mahasiswa SET nama = :nama , jurusan=:jurusan WHERE id = :id")
    void update(int id,String nama,String jurusan);
}