package com.example.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save=findViewById(R.id.saveCustom);
        Button blue=findViewById(R.id.blue);
        Button up=findViewById(R.id.size_up);
        Button back=findViewById(R.id.back);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                //c.getMemBMP();
                ImageView mImageView=findViewById(R.id.mImageView);
                mImageView.setImageBitmap(c.getMemBMP());
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                c.setColor(Color.BLUE);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                c.setSize(10);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                List<Path> l=c.getListStrokes();
                l.remove(l.size()-1);
                c.setListStrokes(l);
                c.drawStrokes();
            }
        });
    }
}