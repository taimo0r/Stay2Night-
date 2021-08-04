package com.taimoor.stay2night.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taimoor.stay2night.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewdViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewed;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewed) {
        this.mostViewed = mostViewed;
    }

    @NonNull
    @Override
    public MostViewdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewdViewHolder mostViewdViewHolder = new MostViewdViewHolder(view);
        return mostViewdViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewdViewHolder holder, int position) {
        MostViewedHelperClass mostViewedHelperClass = mostViewed.get(position);

        holder.image.setImageResource(mostViewedHelperClass.getImage());
        holder.title.setText(mostViewedHelperClass.getTitle());
        holder.description.setText(mostViewedHelperClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return mostViewed.size();
    }

    public static class MostViewdViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, description;

        public MostViewdViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            description = itemView.findViewById(R.id.mv_desc);
        }
    }

}
