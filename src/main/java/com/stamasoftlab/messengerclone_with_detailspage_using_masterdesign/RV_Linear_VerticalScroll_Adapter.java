package com.stamasoftlab.messengerclone_with_detailspage_using_masterdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RV_Linear_VerticalScroll_Adapter extends RecyclerView.Adapter<RV_Linear_VerticalScroll_Adapter.ViewHolder>{

    private static final String TAG = "RV_Linear_Vertical";


    public RV_Linear_VerticalScroll_Adapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mImageNames, ArrayList<String> mimage_details) {
        this.mContext = mContext;
        this.mImages = mImages;
        this.mImageNames = mImageNames;
        this.mimage_details = mimage_details;
    }

    private Context mContext;
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mimage_details =new ArrayList<>();

//    private RV_ClickListener clicklistener = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_linear_vertical_scroll, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;    }

    @Override
    public void onBindViewHolder( ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        holder.imageName.setText(mImageNames.get(position));
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);
        holder.image_details.setText(mimage_details.get(position));



        holder.parentLayout.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetailPage.class);

            // Pass data to DetailPage
            intent.putExtra("image_url", mImages.get(position));
            intent.putExtra("image_name", mImageNames.get(position));
            intent.putExtra("profile_description", mimage_details.get(position));

            mContext.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        TextView image_details;
        LinearLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            //list_Vertical
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            image_details = itemView.findViewById(R.id.image_details);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }

    }

}
