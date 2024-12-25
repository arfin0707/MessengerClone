package com.stamasoftlab.messengerclone_with_detailspage_using_masterdesign;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutProfileActivity extends AppCompatActivity {

  //  private static final String TAG = "AboutProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_profile);

        // Find Views
        CircleImageView profileImage = findViewById(R.id.image_pro);
        TextView profileName = findViewById(R.id.about_profile_name);
        TextView profileDescription = findViewById(R.id.about_profile_description);
        Button callButton = findViewById(R.id.call_button);
        Button messageButton = findViewById(R.id.message_button);
        ImageView backButton = findViewById(R.id.back_button);

        // Extract data from Intent
        String imageUrl = getIntent().getStringExtra("image_url");
        String name = getIntent().getStringExtra("image_name");
        String description = getIntent().getStringExtra("profile_description");

        // Check for null values and update UI
        if (imageUrl != null) {
            Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(profileImage);
        }

        if (name != null) {
            profileName.setText(name);
        }

        if (description != null) {
            profileDescription.setText(description);
        }

        // Button Listeners
       // callButton.setOnClickListener(v -> Log.d(TAG, "Call Button Clicked"));
        //messageButton.setOnClickListener(v -> Log.d(TAG, "Message Button Clicked"));
        backButton.setOnClickListener(v -> finish());
    }
}
