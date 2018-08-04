package com.example.ferdi.exampleroompersistence.adapter;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ferdi.exampleroompersistence.R;
import com.example.ferdi.exampleroompersistence.parcelable.Mahasiswa;
import com.example.ferdi.exampleroompersistence.view.AdapterView;

import java.util.List;

/**
 * Created by ferdi on 7/30/2018.
 */

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewOrder> {

    Activity activity;
    List<?> mahasiswaArrayList;
    AdapterView adapterView;

    public MahasiswaAdapter(Activity activity, List<?> mahasiswaArrayList, AdapterView adapterView) {
        this.activity = activity;
        this.mahasiswaArrayList = mahasiswaArrayList;
        this.adapterView = adapterView;
    }

    @NonNull
    @Override
    public MahasiswaViewOrder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new MahasiswaViewOrder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewOrder holder, final int position) {
        final Mahasiswa mahasiswa = (Mahasiswa) mahasiswaArrayList.get(position);
        holder.nama.setText(mahasiswa.getNama());
        holder.jurusan.setText(mahasiswa.getJurusan());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterView.onClickAdapter(mahasiswa);
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return mahasiswaArrayList.size();
    }
    public class MahasiswaViewOrder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView nama;
        TextView jurusan;


        public MahasiswaViewOrder(View itemView) {
            super(itemView);
            nama =  itemView.findViewById(R.id.tv_nama);
            jurusan = itemView.findViewById(R.id.tv_jurusan);
            cardView = itemView.findViewById(R.id.cv_mahasiswa);
        }
    }
}