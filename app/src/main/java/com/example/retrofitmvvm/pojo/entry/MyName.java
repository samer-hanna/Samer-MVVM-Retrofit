package com.example.retrofitmvvm.pojo.entry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyName {
    @SerializedName("label")
    @Expose
    private String label;

    public MyName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "MyName{" +
                "label='" + label + '\'' +
                '}';
    }
}
