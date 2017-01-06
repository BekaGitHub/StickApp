package app.dfki.de.stickapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.connect.CommandSender;

/**
 * Created by EmpaT on 05.01.2017.
 */

public class GestureRecyclerViewAdapter extends RecyclerView.Adapter<GestureRecyclerViewAdapter.GestureViewHolder> {

    List<String> gestureItems;


    public GestureRecyclerViewAdapter(List<String> gestureItems) {
        this.gestureItems = gestureItems;
    }

    @Override
    public GestureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gesture_recycler_item, parent, false);

        GestureViewHolder gestureViewHolder = new GestureViewHolder(view);
        return gestureViewHolder;
    }

    @Override
    public void onBindViewHolder(final GestureViewHolder holder, int position) {
        holder.itemText.setText(gestureItems.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchItems(String.valueOf(holder.itemText.getText()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return gestureItems.size();
    }


    class GestureViewHolder extends RecyclerView.ViewHolder
    {
        TextView itemText;

        public GestureViewHolder(View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.textViewGestureItem);
        }
    }

    private void switchItems(String item)
    {
        CommandSender sender;

        switch (item)
        {
            case "Clap":
                sender = new CommandSender();
                sender.execute("Gesture-Clap");
                break;
            case "CoverMouth":
                sender = new CommandSender();
                sender.execute("Gesture-CoverMouth");
                break;
            case "Itching":
                sender = new CommandSender();
                sender.execute("Gesture-Itching");
                break;
            case "NoNoNo":
                sender = new CommandSender();
                sender.execute("Gesture-NoNoNo");
                break;
            case "OneTwoThree":
                sender = new CommandSender();
                sender.execute("Gesture-OneTwoThree");
                break;
            case "TouchHead":
                sender = new CommandSender();
                sender.execute("Gesture-TouchHead");
                break;
            case "WaveLeft":
                sender = new CommandSender();
                sender.execute("Gesture-WaveLeft");
                break;
            case "WaveRight":
                sender = new CommandSender();
                sender.execute("Gesture-WaveRight");
                break;
        }
    }
}
