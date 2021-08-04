package com.taimoor.stay2night.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {

    private String image;
    private String title, description, location, price,phoneNo;
    private String key;
    private double longitude, latitude;

    public FeaturedHelperClass(String image, String title, String description, String location, String price, String phoneNo, double longitude, double latitude) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.location = location;
        this.price = price;
        this.phoneNo = phoneNo;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public FeaturedHelperClass(){}

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
