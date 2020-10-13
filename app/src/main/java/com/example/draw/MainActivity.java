package com.example.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save=findViewById(R.id.saveCustom);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomView c=findViewById(R.id.Custom);
                //c.getMemBMP();
                ImageView mImageView=findViewById(R.id.mImageView);
                mImageView.setImageBitmap(c.getMemBMP());
            }
        });
    }
}