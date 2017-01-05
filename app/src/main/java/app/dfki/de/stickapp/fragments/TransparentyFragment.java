package app.dfki.de.stickapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.connect.CommandSender;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransparentyFragment extends Fragment implements View.OnClickListener{

    ToggleButton buttonShoes;
    ToggleButton buttonLips;
    ToggleButton buttonEye;
    ToggleButton buttonBrow;
    ToggleButton buttonNose;
    ToggleButton buttonHead;
    ToggleButton buttonLimbs;
    ToggleButton buttonBody;
    ToggleButton buttonHair;


    public TransparentyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transparenty, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.textView2);

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

        DiscreteSeekBar discreteSeekBar1 = (DiscreteSeekBar) view.findViewById(R.id.discreteSeekBar);
        discreteSeekBar1.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {

                String prefix = getPrefixFromCurrentButton();
                if(prefix != null)
                {
                    textView.setText(String.valueOf(value/100f) + " " + prefix);
                    CommandSender sender = new CommandSender();
                    sender.execute(prefix + "-" + (value/100f));
                }
                return value;
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

    private String getPrefixFromCurrentButton()
    {
        if(buttonBody.isChecked())
            return "OpacityBody";
        else if(buttonBrow.isChecked())
            return "OpacityBrow";
        else if(buttonEye.isChecked())
            return "OpacityEye";
        else if(buttonHair.isChecked())
            return "OpacityHair";
        else if(buttonHead.isChecked())
            return "OpacityHead";
        else if(buttonLimbs.isChecked())
            return "OpacityLimbs";
        else if(buttonLips.isChecked())
            return "OpacityLips";
        else if(buttonNose.isChecked())
            return "OpacityNose";
        else if(buttonShoes.isChecked())
            return "OpacityShoes";
        return null;
    }
}
