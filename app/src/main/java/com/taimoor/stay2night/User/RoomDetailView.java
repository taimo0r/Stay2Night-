package com.taimoor.stay2night.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.taimoor.stay2night.R;

public class RoomDetailView extends AppCompatActivity {

    TextView roomTitle , roomDescription, roomPrice, roomLocation,phoneNo;
    ImageView roomPicture;
    Button bookRoomBtn;

    double longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_room_detail_view);

        //Hooks
        roomTitle =findViewById(R.id.detailRoomTitle);
        roomPrice =findViewById(R.id.detailRoomPrice);
        roomLocation =findViewById(R.id.detailRoomLocation);
        roomDescription =findViewById(R.id.detialRoomDescription);
        roomPicture =findViewById(R.id.mainImage);
        bookRoomBtn =findViewById(R.id.bookRoomButton);
        phoneNo = findViewById(R.id.detailRoomOwner);


        Bundle mbundle = getIntent().getExtras();

        if (mbundle!= null){
            roomTitle.setText(mbundle.getString("Title"));
            roomDescription.setText(mbundle.getString("Description"));
            roomPrice.setText(mbundle.getString("Price"));
            roomLocation.setText(mbundle.getString("Location"));
            phoneNo.setText(mbundle.getString("PhoneNo"));
            Glide.with(this).load(mbundle.getString("Image")).into(roomPicture);
            longitude = mbundle.getDouble("Longitude");
            latitude = mbundle.getDouble("Latitude");
        }

    }

    public void AddtoFavourites(View v)
    {
        Toast.makeText(RoomDetailView.this, "Added to favourites!", Toast.LENGTH_SHORT).show();
    }

    public void BookRoom(View v)
    {
        Toast.makeText(RoomDetailView.this, "Booking Done!", Toast.LENGTH_SHORT).show();
    }

    public void openGoogleMaps(View view) {
        Intent intent = new Intent(getApplicationContext(),RoomsMapLocation.class);
        intent.putExtra("Longitude",longitude);
        intent.putExtra("Latitude",latitude);
        startActivity(intent);
    }
}
