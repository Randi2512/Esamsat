package com.example.esamsat.info.Pembayaran;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esamsat.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPembayaran extends RecyclerView.Adapter<AdapterPembayaran.MyViewHolder>{
    private ArrayList<Result> arrayList;

    public AdapterPembayaran(ArrayList<Result> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterPembayaran.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itempembayaran,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nama_bank.setText(arrayList.get(position).getNama_bank());
        holder.detail.setText(arrayList.get(position).getDetail());

        Picasso.get().load(arrayList.get(position).getImage()).into(holder.image);

        // Glide.with(context).load(arrayList.get(position).getImage()).into(holder.image);
        boolean isVisible = arrayList.get(position).isVisibility();
        holder.constraintLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void notifyDataChanged() {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama_bank;
        ImageView Imagerow;
        TextView detail;
        ShapeableImageView image;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_bank = itemView.findViewById(R.id.txtHeading);
            image = itemView.findViewById(R.id.titleimg);
            detail = itemView.findViewById(R.id.detail);
            constraintLayout = itemView.findViewById(R.id.expanded_layout);
            Imagerow =itemView.findViewById(R.id.imageRow);
            nama_bank.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Result pembayaran = arrayList.get(getAdapterPosition());
                    pembayaran.setVisibility(!pembayaran.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            Imagerow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Result pembayaran = arrayList.get(getAdapterPosition());
                    pembayaran.setVisibility(!pembayaran.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }


    }
    public void setData(ArrayList<Result> newlist)
    { this.arrayList =newlist;}

}
