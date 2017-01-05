package app.dfki.de.stickapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.colorpicker.ColorPicker;
import app.dfki.de.stickapp.connect.CommandSender;
import app.dfki.de.stickapp.util.Utility;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorBrowFragment extends Fragment {


    public ColorBrowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_brow, container, false);
        ImageView leftArrow = (ImageView) view.findViewById(R.id.leftArrow);
        ImageView rightArrow = (ImageView) view.findViewById(R.id.rightArrow);
        Button applyButton = (Button) view.findViewById(R.id.fragmentColorAppyButton);
        final ColorPicker colorPicker = (ColorPicker) view.findViewById(R.id.fragmentColorPicker);

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

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommandSender sender = new CommandSender();
                int color = colorPicker.getColor();
                String rgbString = Color.red(color) + "," + Color.green(color) + "," + Color.blue(color);

                sender.execute("ColorBrow-" + rgbString);
            }
        });
        return view;
    }

}
