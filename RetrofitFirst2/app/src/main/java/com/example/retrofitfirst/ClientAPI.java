package com.example.retrofitfirst;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientAPI {
    @GET("/getStudents")
    Call<List<Student>> getStudents();
}
