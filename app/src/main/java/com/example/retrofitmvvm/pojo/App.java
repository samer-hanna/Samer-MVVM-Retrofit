package com.example.retrofitmvvm.pojo;

import io.realm.RealmList;
import io.realm.RealmObject;

public class App extends RealmObject {
    private String appName;
    public RealmList<String> appImages;
    private String appSummary;
    private String appLink;

    public App() {
    }

    public App(String appName, RealmList<String> appImages, String appSummary, String appLink) {
        this.appName = appName;
        this.appImages = appImages;
        this.appSummary = appSummary;
        this.appLink = appLink;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public RealmList<String> getAppImages() {
        return appImages;
    }

    public void setAppImages(RealmList<String> appImages) {
        this.appImages = appImages;
    }

    public String getAppSummary() {
        return appSummary;
    }

    public void setAppSummary(String appSummary) {
        this.appSummary = appSummary;
    }

    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    @Override
    public String toString() {
        return "App{" +
                "appName='" + appName + '\'' +
                ", appImages=" + appImages +
                ", appSummary='" + appSummary + '\'' +
                ", appLink='" + appLink + '\'' +
                '}';
    }
}
