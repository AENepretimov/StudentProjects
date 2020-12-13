package com.example.delete2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<Video> {
    public VideoAdapter(@NonNull Context context, int resource, @NonNull List<Video> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Video video = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tv_number = convertView.findViewById(R.id.tv_number);
        TextView tv_modul = convertView.findViewById(R.id.tv_modul);
        TextView tv_name = convertView.findViewById(R.id.tv_name);

        tv_number.setText( video.getNumber().toString() );
        tv_modul.setText(video.getNameModul());
        tv_name.setText(video.getNameVideo());

        return convertView;
    }
}
