package com.example.listviewandintenttask;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectedAndroidInfo extends AppCompatActivity {

    TextView androidName, androidDesc;
    ImageView androidIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_android_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        androidName = findViewById(R.id.tvAndroidName);
        androidDesc = findViewById(R.id.tvDescription);
        androidIcon = findViewById(R.id.imgAndroidIcon);

        Intent intent = getIntent();
        String name = intent.getStringExtra("version_name");
        String desc = intent.getStringExtra("description");

        int imageResId = intent.getIntExtra("version_image", 0);

        androidName.setText(name);
        androidDesc.setText(desc);

        if(imageResId != 0){
            androidIcon.setImageResource(imageResId);
        }
    }


}