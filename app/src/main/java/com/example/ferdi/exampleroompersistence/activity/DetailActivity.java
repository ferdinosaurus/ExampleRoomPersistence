package com.example.ferdi.exampleroompersistence.activity;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ferdi.exampleroompersistence.R;
import com.example.ferdi.exampleroompersistence.helper.ActivityHelper;
import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;
import com.example.ferdi.exampleroompersistence.presenter.MahasiswaPresenter;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseConfig;
import com.example.ferdi.exampleroompersistence.sqlite.DatabaseHelper;
import com.example.ferdi.exampleroompersistence.view.MahasiswaView;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements MahasiswaView{

    TextView tv_jurusan,tv_name;
    MahasiswaPresenter mahasiswaPresenter;
    DatabaseHelper databaseHelper;

    Button btn_update,btn_delete;
    Mahasiswa temp_mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        setupListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mahasiswaPresenter.getData(Integer.parseInt(getIntent().getStringExtra("id")));
    }

    public void init(){
        tv_jurusan = findViewById(R.id.tv_jurusan);
        tv_name = findViewById(R.id.tv_nama);
        Toast.makeText(DetailActivity.this, getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();
        databaseHelper = Room.databaseBuilder(DetailActivity.this,DatabaseHelper.class, DatabaseConfig.DATABASE_NAME).allowMainThreadQueries().build();
        mahasiswaPresenter = new MahasiswaPresenter(this,databaseHelper);
        btn_update = findViewById(R.id.btn_update);
        btn_delete= findViewById(R.id.btn_delete);
    }

    public void setupListener(){
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswaPresenter.deleteData(temp_mahasiswa);

            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswaPresenter.getData(Integer.parseInt(getIntent().getStringExtra("id")));
                ActivityHelper.showActivity(DetailActivity.this,AddActivity.class,false,"id",String.valueOf(temp_mahasiswa.getId()));
            }
        });
    }

    @Override
    public void showAllDataUser(List<?> mahasiswaList) {

    }

    @Override
    public void showData(Mahasiswa mahasiswa) {
        temp_mahasiswa = mahasiswa;
            tv_name.setText(mahasiswa.getNama().toString());
            tv_jurusan.setText(mahasiswa.getJurusan().toString());

    }

    @Override
    public void status(long result) {
        if(result!=0){
            finish();
        }
    }
}
