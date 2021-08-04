package com.taimoor.stay2night.Common.LoginSignup;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;
import com.taimoor.stay2night.Databases.CheckInternet;
import com.taimoor.stay2night.R;

public class SetNewPassword extends AppCompatActivity {

    //Variables
    ImageView backbtn;
    private TextInputLayout newPassword, confirmPassword;
    private ImageView screenIcon;
    private TextView title, description;
    private Button update;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        //hook
        newPassword = findViewById(R.id.new_password);
        confirmPassword = findViewById(R.id.new_confirm_password);
        backbtn = findViewById(R.id.SetPassword_backbtn);
        screenIcon = findViewById(R.id.new_password_icon);
        title = findViewById(R.id.new_password_title);
        description = findViewById(R.id.new_password_description);
        update = findViewById(R.id.update_password_btn);

        //Animation hook
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_animation);

        //Set animation to all the  elements
        screenIcon.setAnimation(animation);
        title.setAnimation(animation);
        description.setAnimation(animation);
        newPassword.setAnimation(animation);
        confirmPassword.setAnimation(animation);
        update.setAnimation(animation);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetNewPassword.super.onBackPressed();
            }
        });
    }


    public void call_password_success(View view){

        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
            return;
        }

        if (!validatePassword() | !validateConfirmPassword()){
            return;
        }

        //Get data
        String _newPassword = newPassword.getEditText().getText().toString().trim();
        String _phoneNumber = getIntent().getStringExtra("phoneNo");

        //Update data in firebase
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(_phoneNumber).child("password").setValue(_newPassword);

        startActivity(new Intent(getApplicationContext(),ForgetPasswordSuccessMsg.class));
        finish();
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Please check your internet connecting before logging in")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), RetailerStartupScreen.class));
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();

    }

    //Validation functions
    private boolean validatePassword(){

        String val = newPassword.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                //  "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                // "(?=S+$)";          //no white spaces
                ".{4,}";             //at least 4 characters
        // "$";

        if (val.isEmpty()) {
            newPassword.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkPassword)) {
            newPassword.setError("Password should contain at least 4 characters!");
            return false;
        } else {
            newPassword.setError(null);
            newPassword.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateConfirmPassword(){

        String val = confirmPassword.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                //  "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                // "(?=S+$)";          //no white spaces
                ".{4,}";             //at least 4 characters
        // "$";

        if (val.isEmpty()) {
            confirmPassword.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkPassword)) {
            confirmPassword.setError("Password should contain at least 4 characters!");
            return false;
        } else {
            confirmPassword.setError(null);
            confirmPassword.setErrorEnabled(false);
            return true;
        }

    }

}