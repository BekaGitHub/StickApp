package app.dfki.de.stickapp.coloractivitys;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.colorpicker.ColorPicker;
import app.dfki.de.stickapp.connect.CommandSender;

public class ColorActivity extends AppCompatActivity {

    CommandSender sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_color);

        final ColorPicker colorPicker = (ColorPicker) findViewById(R.id.colorPicker);
        Button applyButton = (Button) findViewById(R.id.colorAppyButton);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = colorPicker.getColor();
                String rgbString = Color.red(color) + "," + Color.green(color) + "," + Color.blue(color);
                String prefix = getIntent().getStringExtra("bodyPart");
                Toast.makeText(ColorActivity.this, prefix, Toast.LENGTH_SHORT).show();
                sender = new CommandSender();
                sender.execute(prefix + "-" + rgbString);
            }
        });
    }
}
