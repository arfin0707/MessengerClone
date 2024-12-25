package com.stamasoftlab.messengerclone_with_detailspage_using_masterdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RV_Linear_HorizontalScroll_Adapter extends RecyclerView.Adapter<RV_Linear_HorizontalScroll_Adapter.ViewHolder>{

    public RV_Linear_HorizontalScroll_Adapter(Context mContext, ArrayList<String> mImageNames_h, ArrayList<String> mImages_h) {
        this.mContext = mContext;
        this.mImageNames_h = mImageNames_h;
        this.mImages_h = mImages_h;
    }

    private Context mContext;
    private ArrayList<String> mImageNames_h ;
    private ArrayList<String> mImages_h;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_linear_horizontal_scroll, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.imageName_h.setText(mImageNames_h.get(position));
        Glide.with(mContext)
                .asBitmap()
                .load(mImages_h.get(position))
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image_h);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DetailPage.class);

                intent.putExtra("image_url_h", mImages_h.get(position));
                intent.putExtra("image_name_h", mImageNames_h.get(position));

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames_h.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image_h;
        TextView imageName_h;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //list_Vertical
            image_h = itemView.findViewById(R.id.image_h);
            imageName_h = itemView.findViewById(R.id.image_name_h);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }

    }


}
