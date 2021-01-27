package com.example.retrofitmvvm.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class PostModel {
    @SerializedName("feed")
    @Expose
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public PostModel(Feed feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "Model{" +
                "feed=" + feed +
                '}';
    }
}
