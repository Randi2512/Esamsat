package com.example.esamsat.info.SamKel.UPTD;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esamsat.R;
import com.example.esamsat.info.SamKel.PERIODE.PeriodeBulan;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<Result> arrayList;

    public Adapter(ArrayList<Result> marrayList) {
        this.arrayList = marrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jadwal,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_uptd.setText(arrayList.get(position).getNama_uptd());
        holder.alamat.setText(arrayList.get(position).getAlamat());
        holder.no_telp.setText(arrayList.get(position).getNo_telp());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PeriodeBulan.class);
                  intent.putExtra("nama", arrayList.get(position).getNama_uptd());
                  view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {
       TextView nama_uptd,alamat,no_telp;
       CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama_uptd = itemView.findViewById(R.id.txtNamaUPTD);
            alamat= itemView.findViewById(R.id.txtLokasiUPTD);
            no_telp=itemView.findViewById(R.id.txtNomor);
            cardView= itemView.findViewById(R.id.cardview);



        }
    }
    public void setData(ArrayList<Result> newlist)
    { this.arrayList =newlist;}
}
