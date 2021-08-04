package com.taimoor.stay2night.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.taimoor.stay2night.Common.LoginSignup.RetailerStartupScreen;
import com.taimoor.stay2night.R;

import java.util.Objects;

public class Profile extends AppCompatActivity {

    TextView name, name1, email;
    Button logout;

    private GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    GoogleSignInAccount signInAccount;

    String _fullName, _phoneNo, _email, _username, _password, _date, _gender, whatToDO;

    ImageView userImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        //Hooks
        userImage = findViewById(R.id.profile_dp);
        name = findViewById(R.id.profile_displayName);
        name1 = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_email);
        logout = findViewById(R.id.profile_logoutBtn);


        //Get data from login
        _fullName = getIntent().getStringExtra("fullName");
        _email = getIntent().getStringExtra("email");
        _username = getIntent().getStringExtra("userName");
        whatToDO = getIntent().getStringExtra("whatToDo");


        LoginUser();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), RetailerStartupScreen.class);
                signInAccount = null;
                startActivity(intent);
                finish();

            }
        });

    }

    private void LoginUser() {

        if (whatToDO.equals("LoginWithGoogle")) {
            signInAccount = GoogleSignIn.getLastSignedInAccount(this);
            if (signInAccount != null) {
                String personImage = Objects.requireNonNull(signInAccount.getPhotoUrl()).toString();
                Glide.with(this).load(personImage).into(userImage);
                name.setText(signInAccount.getDisplayName());
                email.setText(signInAccount.getEmail());
                name1.setText(signInAccount.getGivenName());
            }
        } else {
            name.setText(_fullName);
            email.setText(_email);
            name1.setText(_username);
        }
    }

}