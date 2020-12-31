package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_students);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.46:8080")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ClientAPI clientAPI = retrofit.create(ClientAPI.class);

        Call<List<Student>> call = clientAPI.getStudents();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                students = (List<Student>)response.body();
                //Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                List<String> names = new ArrayList<>(students.size());
                for (Student student : students) {
                    names.add(student.toString());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, names);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}