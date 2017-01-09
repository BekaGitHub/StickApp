package app.dfki.de.stickapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.adapters.BackgroundRecyclerViewAdapter;
import app.dfki.de.stickapp.adapters.HeadRecycleViewAdapter;
import app.dfki.de.stickapp.data.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackgroundFragment extends Fragment {


    public BackgroundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_background, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewBackground);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<Data.BACKGROUND.length; i++)
        {
            list.add(Data.BACKGROUND[i]);
        }

        BackgroundRecyclerViewAdapter backgroundRecyclerViewAdapter = new BackgroundRecyclerViewAdapter(list);
        recyclerView.setAdapter(backgroundRecyclerViewAdapter);

        return view;
    }

}
