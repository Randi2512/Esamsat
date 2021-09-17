package com.example.esamsat.info.Peraturan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esamsat.R;

import java.util.List;

public class PeraturanAdapter extends RecyclerView.Adapter<PeraturanAdapter. ViewHolder> {
    private final List<Peraturan.Result> results ;
    private final OnAdapterListener listener;

    public PeraturanAdapter(List<Peraturan.Result> results, OnAdapterListener listener){
        this.listener = listener;
        this.results = results;
    }



    @NonNull
    @Override
    public PeraturanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_peraturan,parent,false)

        );
    }

    @Override
    public void onBindViewHolder(@NonNull PeraturanAdapter.ViewHolder holder, int position) {
     Peraturan.Result result = results.get(position);
     holder.txtNama.setText(result.getNama());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {listener.onClick(result);}
      });



    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
        }
    }
    public void setData(List<Peraturan.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
    interface OnAdapterListener{
        void onClick(Peraturan.Result result);
    }

}

