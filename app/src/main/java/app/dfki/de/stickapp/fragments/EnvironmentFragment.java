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
import app.dfki.de.stickapp.adapters.EnvironmentRecycleViewAdapter;
import app.dfki.de.stickapp.adapters.GestureRecyclerViewAdapter;
import app.dfki.de.stickapp.data.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnvironmentFragment extends Fragment {


    public EnvironmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_environment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewEnvironment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> gestureList = new ArrayList<>(Arrays.asList(Data.ENVIRONMENT));

        EnvironmentRecycleViewAdapter environmentRecycleViewAdapter = new EnvironmentRecycleViewAdapter(gestureList);
        recyclerView.setAdapter(environmentRecycleViewAdapter);

        return view;
    }

}
