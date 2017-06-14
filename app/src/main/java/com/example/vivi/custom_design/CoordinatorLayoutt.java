package com.example.vivi.custom_design;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by vivi on 17-6-12.
 */

public class CoordinatorLayoutt extends AppCompatActivity {


    private Toolbar toolbar;
    private FloatingActionButton add;
    private ImageView img;
    private boolean a=true;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayoutt);
        add= (FloatingActionButton) findViewById(R.id.addimg);
        img= (ImageView) findViewById(R.id.main_backdrop);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==false)
                {
                    img.setImageResource(R.drawable.a123);
                    a=!a;
                }
                else
                {
                    a=!a;
                    img.setImageResource(R.drawable.timg);
                }

            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("This is a Pig");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitle));

        toolbar.setNavigationIcon(R.drawable.left);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CoordinatorLayoutt.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
