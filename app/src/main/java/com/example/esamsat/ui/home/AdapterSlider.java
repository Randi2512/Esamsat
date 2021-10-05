package com.example.esamsat.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.esamsat.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class AdapterSlider extends SliderViewAdapter<AdapterSlider.IniViewHolder> {
    List<Integer> imageList;
    AdapterSlider(List<Integer> list)
    {
        this.imageList=list;
    }
    @Override
    public IniViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);

        return new IniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IniViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(imageList.get(position));
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    class IniViewHolder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;
        public IniViewHolder(View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
