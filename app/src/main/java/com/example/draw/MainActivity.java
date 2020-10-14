package com.example.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinkedList<Path> r=new LinkedList<Path>();
    LinkedList<Integer> rcolor=new LinkedList<Integer>();
    LinkedList<Integer> rsize=new LinkedList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save=findViewById(R.id.saveCustom);
        Button blue=findViewById(R.id.blue);
        Button up=findViewById(R.id.size_up);
        Button back=findViewById(R.id.back);
        Button red=findViewById(R.id.red);
        Button down=findViewById(R.id.size_down);
        Button go=findViewById(R.id.go);
        Button eraser=findViewById(R.id.Eraser);
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
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomView c=findViewById(R.id.Custom);
                c.setColor(Color.RED);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                c.setSize(10);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomView c=findViewById(R.id.Custom);
                c.setSize(5);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                List<Path> l=c.getListStrokes();
                if(l.size()-1>=0){
                    Log.v("Tag",l.size()+" "+c.getColors().size()+" "+c.getSizes().size());
                    r.push(l.get(l.size()-1));
                    rcolor.push(c.getColors().get(l.size()-1));
                    rsize.push(c.getSizes().get(l.size()-1));
                    l.remove(l.size()-1);   //颜色删除写那边了
                    c.backListStrokes(l);
                    c.drawStrokes();
                }
                else
                    Toast.makeText(MainActivity.this,"没有上一步",Toast.LENGTH_LONG).show();
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomView c=findViewById(R.id.Custom);
                List<Path> l=c.getListStrokes();
                if(!r.isEmpty()){
                    l.add(r.pop());
                    c.goListStrokes(rcolor.pop(),rsize.pop(),l);
                    c.drawStrokes();
                }
            }
        });
        eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomView c=findViewById(R.id.Custom);
                c.setColor(Color.WHITE);
            }
        });
    }
}