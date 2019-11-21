package com.ShresthaGaurav.food_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText sn_first, sn_last, sn_pass, sn_repass;
    ImageButton btn_shoP, btn_showRP;
    TextView sn_dob;
    private boolean isShowPassword = false;
    private boolean isShowREPassword = false;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sn_first = findViewById(R.id.sn_fname);
        sn_last = findViewById(R.id.sn_lname);
        sn_dob = findViewById(R.id.sn_dob);
        sn_pass = findViewById(R.id.sn_pass);
        sn_repass = findViewById(R.id.sn_repass);
        btn_shoP = findViewById(R.id.btn_showpassP);
        btn_shoP.setOnClickListener(this);
        btn_showRP = findViewById(R.id.btn_showpassRP);
        btn_showRP.setOnClickListener(this);
        final DatePickerDialog.OnDateSetListener setdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MMMM /EEEE /yyyy "; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                sn_dob.setText(sdf.format(myCalendar.getTime()));
            }
        };
        sn_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignUp.this, setdate, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        sn_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_shoP.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sn_repass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_showRP.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showpassP:

                if (isShowPassword) {
                    sn_pass.setTransformationMethod(new PasswordTransformationMethod());
                    btn_shoP.setImageDrawable(getResources().getDrawable(R.drawable.ic_panorama_fish_eye_black_24dp));
                    isShowPassword = false;
                    return;
                } else {
                    sn_pass.setTransformationMethod(null);
                    btn_shoP.setImageDrawable(getResources().getDrawable(R.drawable.ic_remove_red_eye_black_24dp));
                    isShowPassword = true;
                    return;
                }
            case R.id.btn_showpassRP:
                if (isShowREPassword) {
                    sn_repass.setTransformationMethod(new PasswordTransformationMethod());
                    btn_showRP.setImageDrawable(getResources().getDrawable(R.drawable.ic_panorama_fish_eye_black_24dp));
                    isShowREPassword = false;
                    return;
                } else {
                    sn_repass.setTransformationMethod(null);
                    btn_showRP.setImageDrawable(getResources().getDrawable(R.drawable.ic_remove_red_eye_black_24dp));
                    isShowREPassword = true;
                    return;
                }

        }

    }
}
