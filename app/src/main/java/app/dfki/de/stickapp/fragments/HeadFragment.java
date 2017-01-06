package app.dfki.de.stickapp.fragments;


import android.os.Bundle;
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
import app.dfki.de.stickapp.adapters.HeadRecycleViewAdapter;
import app.dfki.de.stickapp.data.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeadFragment extends Fragment {


    public HeadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_head, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHead);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> list = new ArrayList<>(Arrays.asList(Data.HEAD));

        HeadRecycleViewAdapter headRecycleViewAdapter = new HeadRecycleViewAdapter(list);
        recyclerView.setAdapter(headRecycleViewAdapter);


        return view;
    }

}
