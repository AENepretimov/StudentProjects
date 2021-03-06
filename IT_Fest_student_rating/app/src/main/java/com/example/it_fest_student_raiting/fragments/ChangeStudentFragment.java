package com.example.it_fest_student_raiting.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.it_fest_student_raiting.MainActivity;
import com.example.it_fest_student_raiting.R;
import com.example.it_fest_student_raiting.db.StudentDbHelper;
import com.example.it_fest_student_raiting.model.Student;

public class ChangeStudentFragment extends Fragment {

    AppCompatButton btn_save;

    EditText et_name;
    EditText et_group;
    EditText et_score;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_student, container, false);

        Student student = (Student) (getArguments().getSerializable(MainActivity.MSG_NAME));
        /*StudentDbHelper dbHelper = new StudentDbHelper(getContext());
        dbHelper.changeStudent(student);


*/
        et_name = view.findViewById(R.id.et_name);
        et_group = view.findViewById(R.id.et_group);
        et_score = view.findViewById(R.id.et_score);

        et_name.setText( student.getName() );
        et_group.setText( student.getGr() );
        et_score.setText( student.getScore().toString() );

        btn_save = (AppCompatButton) view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StudentDbHelper dbHelper = new StudentDbHelper( getContext() );



                Student testStudent = new Student( student.getId(),
                        et_name.getText().toString(),
                        et_group.getText().toString(),
                        Integer.valueOf( et_score.getText().toString() ));

                dbHelper.changeStudent(testStudent);

                getActivity().getSupportFragmentManager().beginTransaction().remove(ChangeStudentFragment.this).commit();

                dbHelper.close();
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).update();
    }

}