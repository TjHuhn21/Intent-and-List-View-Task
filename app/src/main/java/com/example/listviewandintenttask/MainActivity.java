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

        init();
        showMoreInfo();

    }
    public void init(){
        androidVersionLV = findViewById(R.id.androidVersions);
        androidList.add(new AndroidVersionInfo(androidVersions[0], getString(R.string.android_1_desc), R.drawable.android1));
        androidList.add(new AndroidVersionInfo(androidVersions[1], getString(R.string.android_101_desc), R.drawable.android));
        androidList.add(new AndroidVersionInfo(androidVersions[2], getString(R.string.Cupcake_desc), R.drawable.cupcake));
        androidList.add(new AndroidVersionInfo(androidVersions[3], getString(R.string.Donut_desc), R.drawable.donut));
        androidList.add(new AndroidVersionInfo(androidVersions[4], getString(R.string.Eclair_desc), R.drawable.eclair));
        androidList.add(new AndroidVersionInfo(androidVersions[5], getString(R.string.Froyo_desc), R.drawable.froyo));
        androidList.add(new AndroidVersionInfo(androidVersions[6], getString(R.string.Gingerbread_desc), R.drawable.gingerbread));
        androidList.add(new AndroidVersionInfo(androidVersions[7], getString(R.string.Honeycomb_desc), R.drawable.honeycomb));
        androidList.add(new AndroidVersionInfo(androidVersions[8], getString(R.string.Ice_Cream_Sandwich_desc), R.drawable.icecream));
        androidList.add(new AndroidVersionInfo(androidVersions[9], getString(R.string.Jelly_Bean_desc), R.drawable.jellybean));
        androidList.add(new AndroidVersionInfo(androidVersions[10], getString(R.string.Kitkat_desc), R.drawable.kitkat));
        androidList.add(new AndroidVersionInfo(androidVersions[11], getString(R.string.Lollipop_desc), R.drawable.lolipop));
        androidList.add(new AndroidVersionInfo(androidVersions[12], getString(R.string.Marshmallow_desc), R.drawable.marshmallow));
        androidList.add(new AndroidVersionInfo(androidVersions[13], getString(R.string.Nougat_desc), R.drawable.nougat));
        androidList.add(new AndroidVersionInfo(androidVersions[14], getString(R.string.Oreo_desc), R.drawable.oreo));
        androidList.add(new AndroidVersionInfo(androidVersions[15], getString(R.string.Pie_desc), R.drawable.pie));
        androidList.add(new AndroidVersionInfo(androidVersions[16], getString(R.string.Android_10_desc), R.drawable.android10));
        androidList.add(new AndroidVersionInfo(androidVersions[17], getString(R.string.Android_11_desc), R.drawable.android11));
        androidList.add(new AndroidVersionInfo(androidVersions[18], getString(R.string.Android_12_desc), R.drawable.android12));



        androidAdapter = new CustomAdapter(this,androidList);
        androidVersionLV.setAdapter(androidAdapter);
        intent = new Intent(this, SelectedAndroidInfo.class);

    }
    public void showMoreInfo(){
        androidVersionLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AndroidVersionInfo selectedVersion = androidList.get(i);


                String versionName = selectedVersion.getAndroidVersionName();
                String description = selectedVersion.getDescription();
                int imageID = selectedVersion.getImageResourceId();


                intent.putExtra("version_name", versionName);
                intent.putExtra("description", description);
                intent.putExtra("version_image", imageID);

                startActivity(intent);
            }
        });
    }
}