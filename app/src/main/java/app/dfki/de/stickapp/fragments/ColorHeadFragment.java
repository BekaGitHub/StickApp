package app.dfki.de.stickapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.util.Utility;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorHeadFragment extends Fragment {


    public ColorHeadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_head, container, false);
        ImageView leftArrow = (ImageView) view.findViewById(R.id.leftArrow);
        ImageView rightArrow = (ImageView) view.findViewById(R.id.rightArrow);

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations( R.anim.slide_in_left, 0, 0, R.anim.slide_in_right)
                        .replace(R.id.frame, Utility.getPreviousFragment())
                        .commit();
            }
        });

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, 0, 0, R.anim.slide_in_left)
                        .replace(R.id.frame, Utility.getNextFragment())
                        .commit();
            }
        });
        return view;
    }

}
