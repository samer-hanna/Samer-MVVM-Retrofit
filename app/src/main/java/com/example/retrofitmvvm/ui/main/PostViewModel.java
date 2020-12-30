package com.example.retrofitmvvm.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitmvvm.data.PostsClient;
import com.example.retrofitmvvm.pojo.PostModel;
import com.example.retrofitmvvm.pojo.entry.Entry1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<PostModel> postsMutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        // method to return posts from retrofit
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                postsMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });

    }


}
