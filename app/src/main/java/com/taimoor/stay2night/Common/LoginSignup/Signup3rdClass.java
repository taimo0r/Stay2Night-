package com.taimoor.stay2night.Common.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.taimoor.stay2night.R;

public class Signup3rdClass extends AppCompatActivity {

    //Variables
    ImageView getBackbtn;
    ScrollView scrollView;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    //Variables for getting data
    String _fullName, _email, _username, _password, _date, _gender;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_signup3rd_class);

        //Phone authentication Hooks
        scrollView = findViewById(R.id.signup_scrollView);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);

        //hooks
        getBackbtn = findViewById(R.id.signup_back_btn);

        getBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup3rdClass.super.onBackPressed();
            }
        });

        //Get data passed from previous screen using Intent
        _fullName = getIntent().getStringExtra("fullName");
        _email    = getIntent().getStringExtra("email");
        _username = getIntent().getStringExtra("username");
        _password = getIntent().getStringExtra("password");
        _date     = getIntent().getStringExtra("date");
        _gender   = getIntent().getStringExtra("gender");

    }


    public void callOTPScreen(View view) {

        if (!validatePhoneNo()) {
            return;
        }


        //Getting phone Number
        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        //Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
        final String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);


        //Pass all fields to next activity
        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("username", _username);
        intent.putExtra("password", _password);
        intent.putExtra("phoneNo", _phoneNo);
        intent.putExtra("date", _date);
        intent.putExtra("gender", _gender);
        // This is to identify that which action should OTP perform after verification.
        intent.putExtra("whatToDo", "createNewUser");


        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView, "transition_OTP_screen");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup3rdClass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public void call_login_screen(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    private boolean validatePhoneNo() {

        String val = phoneNumber.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid Phone number!");
            return false;
        } else if (!val.matches(checkSpaces)) {
            phoneNumber.setError("No white spaces are allowed");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }

}