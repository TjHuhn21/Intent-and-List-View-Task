package com.example.listviewandintenttask;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import com.example.listviewandintenttask.models.AndroidVersionInfo;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listviewandintenttask.models.AndroidVersionInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String [] androidVersions = {"Android 1.0", "Android 1.1", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kitkat", "Lolipop", "Marshmallow", "Nougat", "Oreo", "Pie", "Android 10", "Android 11", "Android 12"};
    Intent intent;
    ListView androidVersionLV;
    CustomAdapter androidAdapter;

    ArrayList<AndroidVersionInfo> androidList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        androidVersionLV = findViewById(R.id.androidVersions);
        androidList.add(new AndroidVersionInfo(androidVersions[0], getString(R.string.android_1_desc), R.drawable.android1));


        androidAdapter = new CustomAdapter(this,androidList);
        androidVersionLV.setAdapter(androidAdapter);
        showMoreInfo();
    }
    public void showMoreInfo(){
        androidVersionLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AndroidVersionInfo selectedVersion = androidList.get(i);


                String versionName = selectedVersion.getAndroidVersionName();
                String description = selectedVersion.getDescription();
                int imageID = selectedVersion.getImageResourceId();

                intent = new Intent(this, MainActivity2.class);
                intent.putExtra("version_name", versionName);
                intent.putExtra("description", description);
                intent.putExtra("version_image", imageID);

                startActivity(intent);
            }
        });
    }
}