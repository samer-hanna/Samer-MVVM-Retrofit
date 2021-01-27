package com.example.retrofitmvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitmvvm.R;
import com.example.retrofitmvvm.pojo.PostModel;
import com.example.retrofitmvvm.pojo.entry.Entry1;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    RecyclerView recyclerView;
    AppsAdapter adapter;
    ArrayList<Entry1> apps_list;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();



        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        apps_list = new ArrayList<>();

        postViewModel.getPosts();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postViewModel.postsMutableLiveData.observe(this, new Observer<PostModel>() {
            @Override
            public void onChanged(PostModel postModel) {

                ArrayList<Entry1> entries = postModel.getFeed().getEntries();
                Toast.makeText(MainActivity.this, "count = " + entries.size(), Toast.LENGTH_LONG).show();

                //Log.d("TAG", entries.toString());


                for (Entry1 entry : entries)
                {
                    apps_list.add(entry);

                }
                putDataIntoRecyclerView(apps_list);
            }
        });






    }
    private void putDataIntoRecyclerView(ArrayList<Entry1> apps_list) {
        AppsAdapter appsAdapter = new AppsAdapter(this, apps_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(appsAdapter);
    }
}