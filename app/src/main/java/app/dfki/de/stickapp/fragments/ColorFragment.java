package app.dfki.de.stickapp.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import app.dfki.de.stickapp.MainActivity;
import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.coloractivitys.ColorActivity;
import app.dfki.de.stickapp.colorpicker.ColorPicker;
import app.dfki.de.stickapp.connect.CommandSender;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    private ColorPicker colorPicker;
    private Button applyButton;
    CommandSender sender;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        colorPicker = (ColorPicker) view.findViewById(R.id.fragmentColorPicker);
        applyButton = (Button) view.findViewById(R.id.fragmentColorAppyButton);
        Bundle bundle = getArguments();
        final String prefix = bundle.getString("prefix");

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sender = new CommandSender();
                int color = colorPicker.getColor();
                String rgbString = Color.red(color) + "," + Color.green(color) + "," + Color.blue(color);

                sender.execute(prefix+rgbString);
            }
        });
        return view;
    }

    private void switchPrefixAndRun(String prefix)
    {
        switch (prefix)
        {
            case "ColorHead-":
                break;
            case "ColorHair-":
                break;
            case "ColorBody-":
                break;
            case "ColorLimbs-":
                break;
            case "ColorShoes-":
                break;
            case "ColorLips-":
                break;
            case "ColorEye-":
                break;
            case "ColorBrow-":
                break;
            case "ColorNose-":
                break;
        }
    }
}
