package com.example.vivi.custom_design;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout name;
    private TextInputLayout pwd;
    private EditText inname;
    private EditText inpwd;
    private FloatingActionButton actionbutton;
    private AnimatorSet addBill1;
    private AnimatorSet addBill2;
    private RelativeLayout re;
    private boolean isadd=false;
    private FloatingActionButton floating1,floating2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floating1= (FloatingActionButton) findViewById(R.id.flosting1);
        floating2= (FloatingActionButton) findViewById(R.id.flosting2);
         name= (TextInputLayout) findViewById(R.id.name);
         pwd= (TextInputLayout) findViewById(R.id.pwd);
         inname= (EditText) findViewById(R.id.name2);
         re= (RelativeLayout) findViewById(R.id.yincang);
         inpwd= (EditText) findViewById(R.id.pwd2);
        name.setHint("Name");
        pwd.setHint("Password");
        inpwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (inpwd.getText().toString().length()>6) {

                    pwd.setError("密码格式错误");

                }
                else
                {

                    pwd.setError(null);
                }
            }
        });
        inname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (inname.getText().toString().length()>10) {

                    name.setError("用户名格式错误");

                }
                else
                {

                    name.setError(null);
                }
            }
        });
        floating1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CoordinatorLayoutt.class);
                startActivity(intent);
            }
        });
        floating2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,Tablayoutuse.class);
                startActivity(intent2);
            }
        });
        actionbutton = (FloatingActionButton) findViewById(R.id.flosting);

        addBill1= (AnimatorSet)AnimatorInflater.loadAnimator(this,R.animator.add);
        addBill2= (AnimatorSet)AnimatorInflater.loadAnimator(this,R.animator.add);
        actionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isadd)
                {
                    re.setVisibility(View.GONE);
                    isadd=!isadd;
                }
                else
                {
                    re.setVisibility(View.VISIBLE);
                    isadd=!isadd;
                }

                addBill1.setTarget(R.id.fen1);
                addBill1.start();
                addBill2.setTarget(R.id.fen2);
                addBill2.setStartDelay(3000);
                addBill2.start();
            }
        });


    }
}
