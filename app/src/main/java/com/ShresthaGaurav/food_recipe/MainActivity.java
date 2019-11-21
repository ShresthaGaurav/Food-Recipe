package com.ShresthaGaurav.food_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText log_name,log_pass;
Button btn_log,btn_sign;
ImageButton btn_showpass;
TextView txthelp;
    private boolean isShowPassword = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log_name=findViewById(R.id.edLname);
        log_pass=findViewById(R.id.edLpass);
        btn_log=findViewById(R.id.btnlog);
        btn_sign=findViewById(R.id.btnsign);
        txthelp=findViewById(R.id.textHelp);
        btn_showpass=findViewById(R.id.btn_showpass);
        log_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_showpass.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_showpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowPassword) {
                    log_pass.setTransformationMethod(new PasswordTransformationMethod());
                    btn_showpass.setImageDrawable(getResources().getDrawable(R.drawable.ic_panorama_fish_eye_black_24dp));
                    isShowPassword = false;
                }else{
                    log_pass.setTransformationMethod(null);
                    btn_showpass.setImageDrawable(getResources().getDrawable(R.drawable.ic_remove_red_eye_black_24dp));
                    isShowPassword = true;
                }
            }
        });
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sinunwin= new Intent(MainActivity.this,SignUp.class);
                startActivity(sinunwin);
            }
        });
    }
}
