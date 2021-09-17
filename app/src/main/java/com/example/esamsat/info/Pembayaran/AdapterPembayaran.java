package com.example.esamsat.info.Pembayaran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esamsat.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class AdapterPembayaran extends RecyclerView.Adapter<AdapterPembayaran.MyViewHolder>{
    Context context;
    ArrayList<pembayaran> pembayaranArrayList;

    public AdapterPembayaran(Context context,ArrayList<pembayaran> pembayaranArrayList){
        this.context = context;
        this.pembayaranArrayList = pembayaranArrayList;
    }

    @NonNull
    @Override
    public AdapterPembayaran.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_itempembayaran,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        pembayaran pembayaran = pembayaranArrayList.get(position);
        holder.tvHeading.setText(pembayaran.getHeading());
        holder.detail.setText(pembayaran.getDetail());
        holder.titleImage.setImageResource(pembayaran.getTitleImage());

        boolean isVisible = pembayaran.isVisibility();
        holder.constraintLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return pembayaranArrayList.size();
    }

    public void notifyDataChanged() {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvHeading;
        TextView detail;
        ShapeableImageView titleImage;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeading = itemView.findViewById(R.id.txtHeading);
            titleImage = itemView.findViewById(R.id.titleimg);
            detail = itemView.findViewById(R.id.detail);
            constraintLayout = itemView.findViewById(R.id.expanded_layout);

            tvHeading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pembayaran pembayaran = pembayaranArrayList.get(getAdapterPosition());
                    pembayaran.setVisibility(!pembayaran.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }


    }
}
