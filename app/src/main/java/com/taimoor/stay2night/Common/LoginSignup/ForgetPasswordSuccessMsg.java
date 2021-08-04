package com.taimoor.stay2night.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.taimoor.stay2night.R;

public class ForgetPasswordSuccessMsg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_success_msg);
    }

    public void call_login_screen(View view){

        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}