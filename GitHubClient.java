package com.example.hp.Retrofit_pro;
import java.util.List;
import com.example.hp.Retrofit_pro.GitHubRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}