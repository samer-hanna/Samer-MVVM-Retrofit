package com.example.retrofitmvvm.pojo;

import com.example.retrofitmvvm.pojo.entry.Entry1;
import com.example.retrofitmvvm.pojo.entry.Entry1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Feed {
    @SerializedName("entry")
    @Expose
    private ArrayList<Entry1> entries;

    public ArrayList<Entry1> getEntries() {
        return entries;
    }
    public void setEntries(ArrayList<Entry1> entries) {
        this.entries = entries;
    }
    @Override
    public String toString() {
        return "Feed{" +
                "entries=" + entries +
                '}';
    }
    public Feed(ArrayList<Entry1> entries) {
        this.entries = entries;
    }
}
