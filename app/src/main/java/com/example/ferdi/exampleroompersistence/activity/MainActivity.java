package com.example.ferdi.exampleroompersistence.activity;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ferdi.exampleroompersistence.R;
import com.example.ferdi.exampleroompersistence.adapter.MahasiswaAdapter;
import com.example.ferdi.exampleroompersistence.helper.ActivityHelper;
import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;
import com.example.ferdi.exampleroompersistence.presenter.MahasiswaPresenter;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseConfig;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseHelper;
import com.example.ferdi.exampleroompersistence.view.AdapterView;
import com.example.ferdi.exampleroompersistence.view.MahasiswaView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MahasiswaView,AdapterView {


    RecyclerView recyclerView;
    Button btn_add;
    MahasiswaPresenter mahasiswaPresenter;
    DatabaseHelper databaseHelper;
    MahasiswaAdapter mahasiswaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupData();
        setupListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //bug jika function setupData active di onResume
        //setupData();
    }

    public void init(){
        recyclerView = findViewById(R.id.rv_main);
        btn_add = findViewById(R.id.btn_add);
        databaseHelper = Room.databaseBuilder(MainActivity.this,DatabaseHelper.class, DatabaseConfig.DATABASE_NAME).allowMainThreadQueries().build();
        mahasiswaPresenter = new MahasiswaPresenter(this,databaseHelper);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void setupListener(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityHelper.showActivity(MainActivity.this,AddActivity.class,false);
            }
        });
    }
    public void setupData(){
        mahasiswaPresenter.doLoadData();
    }

    @Override
    public void onClickAdapter(Object object) {
        Mahasiswa mahasiswa = (Mahasiswa) object;
        ActivityHelper.showActivity(MainActivity.this,DetailActivity.class,false,"id",String.valueOf(mahasiswa.getId()));
    }

    @Override
    public void showAllDataUser(List<?> mahasiswaList) {

        mahasiswaAdapter = new MahasiswaAdapter(this,mahasiswaList,this);
        recyclerView.setAdapter(mahasiswaAdapter);
    }

    @Override
    public void showData(Mahasiswa mahasiswa) {

    }

    @Override
    public void status(long result) {
    }
}
