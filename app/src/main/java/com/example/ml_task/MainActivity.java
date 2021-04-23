package com.example.ml_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.ml_task.Adapters.SliderAdapter;
import com.rd.PageIndicatorView;

public class MainActivity extends AppCompatActivity {
    SliderAdapter adapter;
    ViewPager viewPager;
    RelativeLayout indicator;
    PageIndicatorView pageIndicatorView;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewpager);
        indicator=findViewById(R.id.indicator);
        adapter=new SliderAdapter(this);
        viewPager.setAdapter(adapter);
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignActivity.class);
                startActivity(intent);
                finish();
            }
        });
        pageIndicatorView=findViewById(R.id.pageIndicator);
        pageIndicatorView.setCount(3);
        ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    next.setVisibility(View.VISIBLE);
                } else {
                    next.setVisibility(View.INVISIBLE);
                }
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        viewPager.addOnPageChangeListener(viewListener);
    }

}