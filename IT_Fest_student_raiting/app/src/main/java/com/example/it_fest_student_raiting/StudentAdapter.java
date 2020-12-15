package com.example.it_fest_student_raiting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.it_fest_student_raiting.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.inflater = LayoutInflater.from(context);
        this.students = students;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView tv_name,
                tv_gr,
                tv_score;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_gr = (TextView) itemView.findViewById(R.id.tv_gr);
            tv_score = (TextView) itemView.findViewById(R.id.tv_score);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        ((MyViewHolder)holder).tv_name.setText(student.getName());
        ((MyViewHolder)holder).tv_gr.setText(student.getGr());
        ((MyViewHolder)holder).tv_score.setText(student.getScore().toString());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
