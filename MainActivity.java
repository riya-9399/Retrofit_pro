package com.example.hp.Retrofit_pro;

import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

import android.view.SurfaceHolder.Callback;


import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView = (ListView) findViewById(R.id.pagination_list);

       retrofit2.Retrofit.Builder builder = new retrofit2.Retrofit.Builder()
                .baseUrl("https://github.com/")
                .addConverterFactory(GsonConverterFactory.create());
       retrofit2.Retrofit retrofit = builder.build();
       GitHubClient client = retrofit.create(GitHubClient.class);
       Call<List<GitHubRepo>> call = client.reposForUser("riya-9399");
        try {
            List<GitHubRepo> result = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }}