package com.example.listviewandintenttask.models;

public class AndroidVersionInfo {
    private String androidVersionName;
    private String description;
    private int imageResourceId;

    public AndroidVersionInfo(String androidVersionName, String description, int imageResourceId){
        this.androidVersionName = androidVersionName;
        this.description = description;
        this.imageResourceId = imageResourceId;

    }

    public String getAndroidVersionName() {
        return androidVersionName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public void setAndroidVersionName(String androidVersionName) {
        this.androidVersionName = androidVersionName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
