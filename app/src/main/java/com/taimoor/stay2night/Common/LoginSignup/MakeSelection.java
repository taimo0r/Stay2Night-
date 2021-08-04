package com.taimoor.stay2night.Common.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.taimoor.stay2night.R;

public class MakeSelection extends AppCompatActivity {

    ImageView backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_make_selection);

        //hooks
        backbtn = findViewById(R.id.Selection_backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeSelection.super.onBackPressed();
            }
        });
    }

    public void CallForgetPassword(View view) {

        startActivity(new Intent(getApplicationContext(), ForgetPssword.class));

    }


}