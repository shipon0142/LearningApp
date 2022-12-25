package com.example.learningapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.learningapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseAdapter extends BaseAdapter {
    private Context mContext;


    //List<String> TITLE = Arrays.asList("Java Programming", "C++ Programming", "Python Programming", "C# Programming", "Web development", "Version Control");
    List<String> TITLE = Arrays.asList("Java", "C++", "Python", "C#", "Php", "Git");
    List<Integer> image = Arrays.asList(R.drawable.java, R.drawable.c_plus_plus, R.drawable.python, R.drawable.c_sharp, R.drawable.php, R.drawable.git);

    // Constructor
    public CourseAdapter(Context c) {
        mContext = c;

    }

    public int getCount() {
        return 6;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView titleTV;
        ImageView imageIV;

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.course, null);
        }
        titleTV=convertView.findViewById(R.id.titleTV);
        imageIV=convertView.findViewById(R.id.imageIV);
        titleTV.setText(TITLE.get(position));
        imageIV.setImageResource(image.get(position));
    


        return convertView;
    }


}
