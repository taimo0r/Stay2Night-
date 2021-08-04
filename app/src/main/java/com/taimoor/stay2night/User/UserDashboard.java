package com.taimoor.stay2night.User;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.taimoor.stay2night.Common.LoginSignup.RetailerStartupScreen;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.taimoor.stay2night.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.taimoor.stay2night.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float End_Scale = 0.7f;
    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    ArrayList<FeaturedHelperClass> featuredLocations;
    FeaturedAdapter featuredAdapter;

    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    EditText searchbar;
    LinearLayout contentView;

    //Database
    private DatabaseReference databaseReference;
    private ValueEventListener eventListener;

    ProgressDialog progressDialog;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private String _fullName,_email,_username, whatToDO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler =(RecyclerView)findViewById(R.id.featured_recyler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        searchbar = findViewById(R.id.search_bar);

        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        _fullName = getIntent().getStringExtra("fullName");
        _email = getIntent().getStringExtra("email");
        _username = getIntent().getStringExtra("userName");
        whatToDO = getIntent().getStringExtra("whatToDo");

        navigationDrawer();

        //Functions will be executed automatically when this activity will be created

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();


    }

    //Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                                           @Override
                                           public void onDrawerSlide(View drawerView, float slideOffset) {
                                               //Scale the view based on current slide offset
                                               final float diffScaledOffset = slideOffset * (1 - End_Scale);
                                               final float offsetScale = 1 - diffScaledOffset;
                                               contentView.setScaleX(offsetScale);
                                               contentView.setScaleY(offsetScale);

                                               //Translate the View, accounting for the scaled width
                                               final float xOffset = drawerView.getWidth() * slideOffset;
                                               final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                                               final float xTranslation = xOffset - xOffsetDiff;
                                               contentView.setTranslationX(xTranslation);


                                           }

                                       }
        );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_categories:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;
            case R.id.nav_profile:
                Intent intent = new Intent(getApplicationContext(),Profile.class);
                intent.putExtra("whatToDo",whatToDO);
                intent.putExtra("fullName",_fullName);
                intent.putExtra("email",_email);
                intent.putExtra("userName",_username);
                startActivity(intent);
                break;
            case R.id.nav_add_room:
                startActivity(new Intent(getApplicationContext(), ListRoom.class));
                break;
        }

        return true;
    }


    //Recycler Views functions
    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();

        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.school_img, "Education", gradient1));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.hospital_img, "Hospital", gradient2));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.restaurant_img, "Restaurant", gradient3));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.shopping_img, "Shopping", gradient4));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.transport_img, "Transport", gradient1));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcdonalds_img, "Mcdonalds", "ajdcjckajkaakuv   ijsvsidsj sdijusc hsb  dhs"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.city_1, "Edenrobe", "ajdcjckajkaakuv   ijsvsidsj sdijusc hsb  dhs"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.city_2, "J.", "ajdcjckajkaakuv   ijsvsidsj sdijusc hsb  dhs"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcdonalds_img, "Walmart", "ajdcjckajkaakuv   ijsvsidsj sdijusc hsb  dhs"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Rooms...");



        //Featured Recycler
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
      //  GridLayoutManager gridLayoutManager = new GridLayoutManager(UserDashboard.this, 1);
        //featuredRecycler.setLayoutManager(gridLayoutManager);

        featuredLocations = new ArrayList<>();

         featuredAdapter = new FeaturedAdapter(UserDashboard.this, featuredLocations);
        featuredRecycler.setAdapter(featuredAdapter);



        databaseReference = FirebaseDatabase.getInstance().getReference("Rooms");
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                featuredLocations.clear();

                for (DataSnapshot itemSnapshot: snapshot.getChildren()){

                    FeaturedHelperClass featuredHelperClass = itemSnapshot.getValue(FeaturedHelperClass.class);

                    featuredHelperClass.setKey(itemSnapshot.getKey());
                    featuredHelperClass.setKey(itemSnapshot.getKey());
                    featuredLocations.add(featuredHelperClass);
                }

                featuredAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss();
            }
        });

        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });



    }

    private void filter(String text) {

        ArrayList<FeaturedHelperClass> filterList = new ArrayList<>();
        for ( FeaturedHelperClass item: featuredLocations){
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterList.add(item);
            }
        }


        featuredAdapter.filteredList(filterList);

    }


    public void callRetailerScreen(View view) {

        startActivity(new Intent(getApplicationContext(), RetailerStartupScreen.class));

    }



    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }


    public void CallCategoriesScreen(View view) {
        startActivity(new Intent(getApplicationContext(),AllCategories.class));
    }
}