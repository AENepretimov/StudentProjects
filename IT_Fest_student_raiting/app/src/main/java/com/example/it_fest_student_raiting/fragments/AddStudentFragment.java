package com.example.it_fest_student_raiting.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.it_fest_student_raiting.R;
import com.example.it_fest_student_raiting.db.StudentDbHelper;
import com.example.it_fest_student_raiting.db.StudentReaderContract;
import com.example.it_fest_student_raiting.model.Student;

public class AddStudentFragment extends Fragment {
    AppCompatButton btn_add;


    StudentDbHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Student testStudent = new Student(1, "Ivan", "mp1", 10);

        dbHelper = new StudentDbHelper( getContext() );
        dbHelper.addStudent(testStudent);

        btn_add = (AppCompatButton) getView().findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(AddStudentFragment.this).commit();
            }
        });
    }
}