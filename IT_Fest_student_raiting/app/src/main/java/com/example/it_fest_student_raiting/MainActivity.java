package com.example.it_fest_student_raiting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.it_fest_student_raiting.db.StudentDbHelper;
import com.example.it_fest_student_raiting.db.StudentReaderContract;
import com.example.it_fest_student_raiting.fragments.AddStudentFragment;
import com.example.it_fest_student_raiting.fragments.ChangeStudentFragment;
import com.example.it_fest_student_raiting.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MSG_NAME = "msg";
    AddStudentFragment addStudentFragment;
    ChangeStudentFragment changeStudentFragment;
    FragmentTransaction transaction;
    FrameLayout frameLayout;
    RecyclerView rv_students;

    List<Student> students;

    StudentDbHelper dbHelper;

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new StudentDbHelper(this);
        students = dbHelper.getStudents();

        addStudentFragment = new AddStudentFragment();
        changeStudentFragment = new ChangeStudentFragment();

        rv_students = findViewById(R.id.rv_students);
        StudentAdapter studentAdapter = new StudentAdapter(this, students);
        rv_students.setAdapter(studentAdapter);

        frameLayout = findViewById(R.id.fl_main);
        ((AppCompatButton) findViewById(R.id.btn_change)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(MSG_NAME, 1);
                changeStudentFragment.setArguments(bundle);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_main, changeStudentFragment);
                transaction.commit();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_main, addStudentFragment);
                transaction.commit();


                Snackbar.make(view, "Here's a Snackbar", 20000)
                        .setAction("Action", null).show();
            }
        });
    }


}