package com.taimoor.stay2night.HelperClasses.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.taimoor.stay2night.R;
import com.taimoor.stay2night.User.RoomDetailView;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    Context mContext;
    ArrayList<FeaturedHelperClass> featuredLocations;
    private int lastPosition = -1;

    public FeaturedAdapter(Context mContext, ArrayList<FeaturedHelperClass> featuredLocations) {
        this.mContext = mContext;
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

        //Set data in RecyclerView
        Glide.with(mContext).load(featuredHelperClass.getImage()).into(holder.image);
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());
        holder.roomLocation.setText(featuredHelperClass.getLocation());
        holder.roomPrice.setText(featuredHelperClass.getPrice());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {

            //Pass Data to RoomDetailView
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RoomDetailView.class);

                intent.putExtra("Image", featuredHelperClass.getImage());
                intent.putExtra("Description", featuredHelperClass.getDescription());
                intent.putExtra("Title", featuredHelperClass.getTitle());
                intent.putExtra("Price", featuredHelperClass.getPrice());
                intent.putExtra("Location", featuredHelperClass.getLocation());
                intent.putExtra("PhoneNo", featuredHelperClass.getPhoneNo());
                intent.putExtra("Latitude", featuredHelperClass.getLatitude());
                intent.putExtra("Longitude", featuredHelperClass.getLongitude());
                mContext.startActivity(intent);
            }
        });


        setAnimation(holder.itemView,position);

    }

    public void setAnimation(View viewToAnimate, int position) {

        if (position > lastPosition) {

            ScaleAnimation animation = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            animation.setDuration(500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public void filteredList(ArrayList<FeaturedHelperClass> filterList) {
        featuredLocations = filterList;
        notifyDataSetChanged();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc, location, price, roomLocation, roomPrice;
        CardView mCardView;


        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);
            roomLocation = itemView.findViewById(R.id.roomLocation);
            roomPrice = itemView.findViewById(R.id.roomPrice);
            mCardView = itemView.findViewById(R.id.featuredCardView);
            location = itemView.findViewById(R.id.location);
            price = itemView.findViewById(R.id.price);
        }
    }
}
