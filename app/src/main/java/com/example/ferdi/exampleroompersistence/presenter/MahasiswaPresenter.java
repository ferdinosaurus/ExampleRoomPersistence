package com.example.ferdi.exampleroompersistence.presenter;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseHelper;
import com.example.ferdi.exampleroompersistence.view.MahasiswaView;

import java.util.List;

/**
 * Created by ferdi on 8/2/2018.
 */

public class MahasiswaPresenter {

    MahasiswaView mahasiswaView;
    DatabaseHelper databaseHelper;

    public MahasiswaPresenter(MahasiswaView mahasiswaView, DatabaseHelper databaseHelper){
        this.mahasiswaView = mahasiswaView;
        this.databaseHelper = databaseHelper;
    }

    public void doLoadData(){
        List<Mahasiswa> mahasiswaList = databaseHelper.mahasiswaDao().getAll();
        mahasiswaView.showAllDataUser(mahasiswaList);

    }
    public void addData(final Mahasiswa mahasiswa){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Long result = databaseHelper.mahasiswaDao().insertOnlySingleMahasiswa(mahasiswa);
                mahasiswaView.status(result);

            }
        });

    }
    public void deleteData(final Mahasiswa mahasiswa){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                databaseHelper.mahasiswaDao().delete(mahasiswa);
                mahasiswaView.status(1);
            }
        });
    }
    public void getData(final int id){
        /*
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                */
                Mahasiswa mahasiswa = databaseHelper.mahasiswaDao().getMahasiswaById(id);
                mahasiswaView.showData(mahasiswa);
            /*}
        });
        */

    }
    public void update(final Mahasiswa mahasiswa){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                databaseHelper.mahasiswaDao().update(mahasiswa.getId(),mahasiswa.getNama(),mahasiswa.getJurusan());
                mahasiswaView.status(1);
            }
        });
    }
}