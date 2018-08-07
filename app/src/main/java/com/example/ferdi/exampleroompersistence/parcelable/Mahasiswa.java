package com.example.ferdi.exampleroompersistence.parcelable;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ferdi on 7/30/2018.
 */
@Entity
public class Mahasiswa {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;
    String nama;
    String jurusan;

    public Mahasiswa(String nama, String jurusan) {
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
