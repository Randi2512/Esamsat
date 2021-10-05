package com.example.esamsat.info.SamKel.PERIODE;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esamsat.R;

import java.util.ArrayList;

public class AdapterPeriode extends RecyclerView.Adapter<AdapterPeriode.MyViewHolder> {
    private ArrayList<Result> arrayList;

    public AdapterPeriode(ArrayList<Result> marrayList) {
        this.arrayList = marrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_periode,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bulan.setText(arrayList.get(position).getBulan());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bulan;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bulan =itemView.findViewById(R.id.txtbulan);

        }
    }
    public void setData(ArrayList<Result> newlist)
    { this.arrayList =newlist;}
}
