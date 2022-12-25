
package com.example.learningapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learningapp.adapter.CourseAdapter;
import com.example.learningapp.utils.ExpandableHeightGridView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private ExpandableHeightGridView gridview;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        gridview=view.findViewById(R.id.gridview);
        CourseAdapter courseAdapter = new CourseAdapter(getContext());
        gridview.setExpanded(true);
        gridview.setAdapter(courseAdapter);
/*        Slider.init(new PicassoImageLoadingService(getContext()));
        banner_slider1 = root.findViewById(R.id.banner_slider1);
        List<Integer> banner=new ArrayList<>();

        banner.add(R.drawable.ban1);
        banner.add(R.drawable.ban2);
        banner.add(R.drawable.ban3);
        banner.add(R.drawable.ban4);

        MainSliderAdopter mainSliderAdopter = new MainSliderAdopter(banner);
        banner_slider1.setClipToOutline(true);
        banner_slider1.setAdapter(mainSliderAdopter);
        banner_slider1.setInterval(3000);*/
        return view;

    }
}