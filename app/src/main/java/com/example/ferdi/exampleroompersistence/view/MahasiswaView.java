package com.example.ferdi.exampleroompersistence.view;

import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;

import java.util.List;

/**
 * Created by ferdi on 8/2/2018.
 */

public interface MahasiswaView{
    void showAllDataUser(List<?> mahasiswaList);
    void showData(Mahasiswa mahasiswa);
    void status(long result);
}
