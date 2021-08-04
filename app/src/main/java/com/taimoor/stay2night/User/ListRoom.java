package com.taimoor.stay2night.User;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.taimoor.stay2night.HelperClasses.LocationHelperClass;
import com.taimoor.stay2night.R;

import java.text.DateFormat;
import java.util.Calendar;

public class ListRoom extends AppCompatActivity {

    Uri uri;
    ImageView roomImage;
    TextInputLayout title, location, price, description, phoneNo;
    Button selectLocation;


    GoogleMaps googleMaps = new GoogleMaps();


    long roomId;
    double longitude, latitude;
    int PLACE_PICKER_REQUEST = 1;
    String imageUrl, UserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_room);

        //Hooks
        roomImage = findViewById(R.id.RoomImage);
        title = findViewById(R.id.room_title);
        location = findViewById(R.id.room_Location);
        price = findViewById(R.id.room_price);
        description = findViewById(R.id.room_description);
        phoneNo = findViewById(R.id.listRoom_phone_number);
        selectLocation = findViewById(R.id.pickLocation);
    }

    public void openGallery(View view) {

        Intent imagePicker = new Intent(Intent.ACTION_PICK);
        imagePicker.setType("image/*");
        startActivityForResult(imagePicker, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            uri = data.getData();
            roomImage.setImageURI(uri);
        } else {
            Toast.makeText(this, "No Image selected!", Toast.LENGTH_SHORT).show();
        }
    }

    public void UploadImg() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Listing Your Room...");
        progressDialog.show();

        StorageReference storageReference = FirebaseStorage.getInstance()
                .getReference().child("RoomImage").child(uri.getLastPathSegment());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete()) ;
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                uploadRoomDetail();
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(ListRoom.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listRoomBtn(View view) {

        if (!validatePhoneNo() | !validatePrice() | !validateLocation() | !validateDesc() |   !validateTitle()) {
            return;
        }

        UploadImg();
    }


    public void uploadRoomDetail() {


        String _getUserEnteredPhoneNumber = phoneNo.getEditText().getText().toString().trim();
        String _getUserEnteredPrice = price.getEditText().getText().toString();

        //Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }


        longitude = getIntent().getDoubleExtra("Longitude",0);
        latitude = getIntent().getDoubleExtra("Latitude",0);

        LocationHelperClass locationHelperClass = new LocationHelperClass(latitude,longitude);


        final String phoneNumber = "+92" + _getUserEnteredPhoneNumber;
        final String price = _getUserEnteredPrice + "RS.";


        String myCurrentDateTime =
                DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FeaturedHelperClass featuredHelperClass = new FeaturedHelperClass(
                imageUrl,
                title.getEditText().getText().toString(),
                description.getEditText().getText().toString(),
                location.getEditText().getText().toString(),
                price,
                phoneNumber,
                longitude,
                latitude
        );



        FirebaseDatabase.getInstance().getReference("Rooms")
                .child(myCurrentDateTime).setValue(featuredHelperClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(ListRoom.this, "Room Listed Successfully", Toast.LENGTH_SHORT).show();
                    finish();

                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(ListRoom.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateTitle() {

        String _title = title.getEditText().getText().toString().trim();
        if (_title.isEmpty()) {
            title.setError("Field cannot be empty");
            title.requestFocus();
            return false;
        } else {
            title.setError(null);
            title.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePrice() {
        String _price = price.getEditText().getText().toString().trim();
        if (_price.isEmpty()) {
            price.setError("Field cannot be empty");
            price.requestFocus();
            return false;
        } else {
            price.setError(null);
            price.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateLocation() {

        String _location = location.getEditText().getText().toString().trim();
        if (_location.isEmpty()) {
            location.setError("Field cannot be empty");
            location.requestFocus();
            return false;
        } else {
            location.setError(null);
            location.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateDesc() {
        String _description = description.getEditText().getText().toString().trim();
        if (_description.isEmpty()) {
            description.setError("Field cannot be empty");
            description.requestFocus();
            return false;
        } else {
            description.setError(null);
            description.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNo() {

        String val = phoneNo.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            phoneNo.setError("Enter valid Phone number!");
            phoneNo.requestFocus();
            return false;

        } else {
            phoneNo.setError(null);
            phoneNo.setErrorEnabled(false);
            return true;
        }
    }

    public void openLocation(View view) {
       startActivity(new Intent(getApplicationContext(),GoogleMaps.class));
       finish();
    }


}