package com.example.listviewandintenttask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewandintenttask.models.AndroidVersionInfo;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<AndroidVersionInfo> {
    private Context versionContext;
    private List<AndroidVersionInfo> androidVersionInfoList;

    public CustomAdapter(Context versionContext, ArrayList<AndroidVersionInfo> list){
        super(versionContext, 0 , list);
        this.versionContext = versionContext;
        this.androidVersionInfoList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(versionContext).inflate(R.layout.items_layout, parent, false);
        }
        AndroidVersionInfo currentVersion = androidVersionInfoList.get(position);

        ImageView versionImage = listItem.findViewById(R.id.versionIcon);
        TextView versionName = listItem.findViewById(R.id.versionName);
        TextView description = listItem.findViewById(R.id.versionDescription);

        if(currentVersion != null){
            versionImage.setImageResource(currentVersion.getImageResourceId());
            versionName.setText(currentVersion.getAndroidVersionName());
            description.setText(currentVersion.getDescription());
        }
        return listItem;
    }
}
