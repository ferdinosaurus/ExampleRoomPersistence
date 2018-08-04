package com.example.ferdi.exampleroompersistence.activity;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ferdi.exampleroompersistence.R;
import com.example.ferdi.exampleroompersistence.helper.ActivityHelper;
import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;
import com.example.ferdi.exampleroompersistence.presenter.MahasiswaPresenter;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseConfig;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseHelper;
import com.example.ferdi.exampleroompersistence.view.MahasiswaView;

import java.util.List;

public class AddActivity extends AppCompatActivity implements MahasiswaView {

    DatabaseHelper databaseHelper;
    MahasiswaPresenter mahasiswaPresenter;

    EditText et_nama,et_jurusan;
    Button btn_submit;
    Mahasiswa mahasiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        setupListener();
    }

    public void init(){
        databaseHelper = Room.databaseBuilder(AddActivity.this,DatabaseHelper.class, DatabaseConfig.DATABASE_NAME).fallbackToDestructiveMigration().build();
        mahasiswaPresenter = new MahasiswaPresenter(this,databaseHelper);
        et_nama = findViewById(R.id.et_nama);
        et_jurusan = findViewById(R.id.et_jurusan);
        btn_submit = findViewById(R.id.btn_submit);


    }
    public void setupListener(){
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                    mahasiswa = new Mahasiswa(et_nama.getText().toString(), et_jurusan.getText().toString());
                    mahasiswaPresenter.addData(mahasiswa);

            }
        });
    }
    @Override
    public void showAllDataUser(List<?> mahasiswaList) {

    }

    @Override
    public void showData(Mahasiswa mahasiswa) {
        et_nama.setText(mahasiswa.getNama());
        et_jurusan.setText(mahasiswa.getJurusan());
    }

    @Override
    public void status(long result) {
        if(result!=0){
            ActivityHelper.showActivity(AddActivity.this,MainActivity.class,true);
        }


    }
}
