package com.example.retrofitmvvm.pojo.entry;


import com.example.retrofitmvvm.pojo.entry.images.Image1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Entry1 {
    @SerializedName("im:name")
    @Expose
    private MyName name;

    @SerializedName("im:image")
    @Expose
    private ArrayList<Image1> image;

    @SerializedName("summary")
    @Expose
    private Summary summary;

    @SerializedName("id")
    @Expose
    private MyId id;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public MyId getId() {
        return id;
    }

    public void setId(MyId id) {
        this.id = id;
    }

    public MyName getName() {
        return name;
    }

    public void setName(MyName name) {
        this.name = name;
    }

    public ArrayList<Image1> getImage() {
        return image;
    }

    public void setImage(ArrayList<Image1> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Entry1{" +
                "name=" + name +
                ", image=" + image +
                ", summary=" + summary +
                ", id=" + id +
                '}';
    }
}
