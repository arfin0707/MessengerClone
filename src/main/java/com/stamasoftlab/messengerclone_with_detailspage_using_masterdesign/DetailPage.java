package com.stamasoftlab.messengerclone_with_detailspage_using_masterdesign;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailPage extends AppCompatActivity {
    private static final String TAG = "Details Page";

    private String imageUrl;
    private String imageName;
    private String profileDescription;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.detailed_profile);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntentVertical();
        getIncomingIntent_horizontal();

    }



    private void getIncomingIntentVertical(){

/*        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            setImage(imageUrl, imageName);
        }*/


        // Extract data from Intent
        imageUrl = getIntent().getStringExtra("image_url");
        imageName = getIntent().getStringExtra("image_name");
        profileDescription = getIntent().getStringExtra("profile_description");

        if (imageUrl != null && imageName != null && profileDescription != null) {
            setImage(imageUrl, imageName);

            // Set up View Profile button
/*
            Button viewProfileButton = findViewById(R.id.view_profile_button);
            viewProfileButton.setOnClickListener(v -> {
                Intent intent = new Intent(DetailPage.this, AboutProfileActivity.class);
                intent.putExtra("image_url", imageUrl);
                intent.putExtra("image_name", imageName);
                intent.putExtra("profile_description", profileDescription);
                startActivity(intent);
            });
*/

            // Set up the View Profile button action
            Button viewProfileButton = findViewById(R.id.view_profile_button);
            viewProfileButton.setOnClickListener(v -> {
                Intent intent = new Intent(DetailPage.this, AboutProfileActivity.class);
                intent.putExtra("image_url", imageUrl);
                intent.putExtra("image_name", imageName);
                intent.putExtra("profile_description", profileDescription);

                startActivity(intent);
            });
        }
    }


    private void setImage(String imageUrl, String imageName){

    //BottomPart of detailPage
        ImageView image = findViewById(R.id.image_pro);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        TextView name = findViewById(R.id.image_name_pro);
        name.setText(imageName);


    //TopPart of detailPage
        ImageView imagetop = findViewById(R.id.image_top);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imagetop);

        TextView nametop = findViewById(R.id.image_name_top);
        nametop.setText(imageName);
    }



    private void getIncomingIntent_horizontal(){

        //get
        if(getIntent().hasExtra("image_url_h") && getIntent().hasExtra("image_name_h")){
            String imageUrl = getIntent().getStringExtra("image_url_h");
            String imageName = getIntent().getStringExtra("image_name_h");

        //setImage(imageUrl, imageName);
            //Find Id
            ImageView image = findViewById(R.id.image_pro);
            TextView name = findViewById(R.id.image_name_pro);
            ImageView imagetop = findViewById(R.id.image_top);
            TextView nametop = findViewById(R.id.image_name_top);

            //set

            Glide.with(this)
                    .asBitmap()
                    .load(imageUrl)
                    .into(image);

            name.setText(imageName);

            Glide.with(this)
                    .asBitmap()
                    .load(imageUrl)
                    .into(imagetop);

            nametop.setText(imageName);

        }
    }



}