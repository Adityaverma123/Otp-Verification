package com.example.ml_task.Adapters;

import android.content.Context;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ml_task.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    public int[] slide_images={R.drawable.image1,R.drawable.image2,R.drawable.image3};

    public SliderAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.slide_layout,container,false);
        ImageView imageView=view.findViewById(R.id.image_view);
        imageView.setImageResource(slide_images[position]);
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
