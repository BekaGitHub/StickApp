package app.dfki.de.stickapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.colorpicker.ColorPicker;
import app.dfki.de.stickapp.connect.CommandSender;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment implements View.OnClickListener{

    private ColorPicker colorPicker;
    private Button applyButton;
    private Button resetButton;

    ToggleButton buttonShoes;
    ToggleButton buttonLips;
    ToggleButton buttonEye;
    ToggleButton buttonBrow;
    ToggleButton buttonNose;
    ToggleButton buttonHead;
    ToggleButton buttonLimbs;
    ToggleButton buttonBody;
    ToggleButton buttonHair;

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
        resetButton = (Button) view.findViewById(R.id.buttonReset);

        //control stuff
         buttonShoes = (ToggleButton) view.findViewById(R.id.toggleButtonShoes);
         buttonLips = (ToggleButton) view.findViewById(R.id.toggleButtonLips);
         buttonEye = (ToggleButton) view.findViewById(R.id.toggleButtonEye);
         buttonBrow = (ToggleButton) view.findViewById(R.id.toggleButtonBrow);
         buttonNose = (ToggleButton) view.findViewById(R.id.toggleButtonNose);
         buttonHead = (ToggleButton) view.findViewById(R.id.toggleButtonHead);
         buttonLimbs = (ToggleButton) view.findViewById(R.id.toggleButtonLimbs);
         buttonBody = (ToggleButton) view.findViewById(R.id.toggleButtonBody);
         buttonHair = (ToggleButton) view.findViewById(R.id.toggleButtonHair);

        buttonShoes.setOnClickListener(this);
        buttonLips.setOnClickListener(this);
        buttonEye.setOnClickListener(this);
        buttonBrow.setOnClickListener(this);
        buttonNose.setOnClickListener(this);
        buttonHead.setOnClickListener(this);
        buttonLimbs.setOnClickListener(this);
        buttonBody.setOnClickListener(this);
        buttonHair.setOnClickListener(this);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonShoes.isChecked())
                    sendCommand("ColorShoes");
                else if(buttonNose.isChecked())
                    sendCommand("ColorNose");
                else if(buttonLips.isChecked())
                    sendCommand("ColorLips");
                else if(buttonLimbs.isChecked())
                    sendCommand("ColorLimbs");
                else if(buttonBody.isChecked())
                    sendCommand("ColorBody");
                else if(buttonBrow.isChecked())
                    sendCommand("ColorBrow");
                else if(buttonEye.isChecked())
                    sendCommand("ColorEye");
                else if(buttonHair.isChecked())
                    sendCommand("ColorHair");
                else if(buttonHead.isChecked())
                    sendCommand("ColorHead");
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommand("Reset");
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        checkoutAllWithout(v.getId());
    }



    private void checkoutAllWithout(int ID)
    {
         if(ID != buttonBrow.getId())
            buttonBrow.setChecked(false);
         if(ID != buttonBody.getId())
            buttonBody.setChecked(false);
         if(ID != buttonEye.getId())
            buttonEye.setChecked(false);
         if(ID != buttonHair.getId())
            buttonHair.setChecked(false);
         if(ID != buttonHead.getId())
            buttonHead.setChecked(false);
         if(ID != buttonLimbs.getId())
            buttonLimbs.setChecked(false);
         if(ID != buttonLips.getId())
            buttonLips.setChecked(false);
         if(ID != buttonNose.getId())
            buttonNose.setChecked(false);
         if(ID != buttonShoes.getId())
            buttonShoes.setChecked(false);
    }

    private void sendCommand(String message)
    {
        CommandSender sender = new CommandSender();
        int color = colorPicker.getColor();
        String rgbString = Color.red(color) + "," + Color.green(color) + "," + Color.blue(color);

        sender.execute(message + "-" + rgbString);
    }
}
