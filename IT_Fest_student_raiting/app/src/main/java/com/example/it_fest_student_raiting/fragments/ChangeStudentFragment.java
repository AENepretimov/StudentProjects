package com.example.it_fest_student_raiting.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.it_fest_student_raiting.MainActivity;
import com.example.it_fest_student_raiting.R;

public class ChangeStudentFragment extends Fragment {

    AppCompatButton btn_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_student, container, false);

        ((TextView) view.findViewById(R.id.tv_test)).setText( String.valueOf( getArguments().getInt(MainActivity.MSG_NAME) ));

        btn_save = (AppCompatButton) view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(ChangeStudentFragment.this).commit();
            }
        });

        return view;
    }


}