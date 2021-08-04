package com.taimoor.stay2night.Common.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.taimoor.stay2night.R;

import java.util.Calendar;

public class Signup2ndClass extends AppCompatActivity {

    //Variables
    ImageView backtbn, getBackbtn;
    Button next, login;
    TextView titletxt, slideText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    //Variables for passing data
    String _fullName, _email, _username, _password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_signup2nd_class);

        //hooks
        backtbn = findViewById(R.id.signup_back_btn);
        next = findViewById(R.id.signup_next_btn);
        login = findViewById(R.id.signup_login_btn);
        titletxt = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);


        //hooks
        getBackbtn = findViewById(R.id.signup_back_btn);

        getBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup2ndClass.super.onBackPressed();

            }
        });

        //Get data passed from previous screen using Intent
        _fullName = getIntent().getStringExtra("fullName");
        _email = getIntent().getStringExtra("email");
        _username = getIntent().getStringExtra("username");
        _password = getIntent().getStringExtra("password");

    }


    public void callNextSignupScreen(View view) {

        if (!validateAge() | !validateGender()) {
            return;
        }


        Intent intent = new Intent(getApplicationContext(), Signup3rdClass.class);

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = selectedGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        String date = day + "/" + month + "/" + year;

        ///Pass all data to next activity
        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("username", _username);
        intent.putExtra("password", _password);
        intent.putExtra("gender", gender);
        intent.putExtra("date", date);


        //Add Transition
        Pair[] pairs = new Pair[5];

        pairs[0] = new Pair<View, String>(backtbn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titletxt, "transition_title_text");
        pairs[4] = new Pair<View, String>(slideText, "transition_slide_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup2ndClass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }

    public void call_login_screen(View view) {

        startActivity(new Intent(getApplicationContext(), Login.class));

    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {

            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

    private boolean validateAge() {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "Age must be over 14 years to Signup", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

}