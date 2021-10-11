package com.example.esamsat.ui.SamkelToday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esamsat.R;

import java.util.ArrayList;

import retrofit2.Response;

public class AdapterSToday extends RecyclerView.Adapter<AdapterSToday.MyViewHolder> {

    private ArrayList<Result> arrayList;
    public AdapterSToday(ArrayList<Result> marrayList) {
        this.arrayList = marrayList;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_samkel,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.kabupaten.setText(arrayList.get(position).getKabupaten());
        holder.kecamatan.setText(arrayList.get(position).getKecamatan());
        holder.tanggal.setText(arrayList.get(position).getTanggal());
        holder.jadwal.setText(arrayList.get(position).getJadwal());
        holder.lokasi.setText(arrayList.get(position).getLokasi());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView  kabupaten,kecamatan,  jadwal ,tanggal,lokasi;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            kabupaten =itemView.findViewById(R.id.NamaKota);
            kecamatan = itemView.findViewById(R.id.txtKecamatan);
            jadwal = itemView.findViewById(R.id.txtJadwal);
            tanggal = itemView.findViewById(R.id.txttanggal);
            lokasi = itemView.findViewById(R.id.txtLokasi);
        }
    }
    public void setData(ArrayList<Result> newlist)
    { this.arrayList =newlist;}

}
