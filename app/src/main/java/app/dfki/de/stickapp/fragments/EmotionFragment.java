package app.dfki.de.stickapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.data.Data;
import app.dfki.de.stickapp.recyclerviewadapter.RecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmotionFragment extends Fragment {


    public EmotionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emotion, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);


        List<String> emotionList = new ArrayList<>(Arrays.asList(Data.EMOTIONS));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(emotionList);
        recyclerView.setAdapter(recyclerViewAdapter);


        return view;
    }

}
