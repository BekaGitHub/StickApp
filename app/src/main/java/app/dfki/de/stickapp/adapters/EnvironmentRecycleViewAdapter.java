package app.dfki.de.stickapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.connect.CommandSender;
import app.dfki.de.stickapp.data.Data;

/**
 * Created by EmpaT on 06.01.2017.
 */

public class EnvironmentRecycleViewAdapter extends RecyclerView.Adapter<EnvironmentRecycleViewAdapter.EnvironmentViewHolder> {

    List<String> list;

    public EnvironmentRecycleViewAdapter(List<String> list) {

        this.list = list;
    }

    @Override
    public EnvironmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gesture_recycler_item, parent, false);
        EnvironmentViewHolder environmentViewHolder = new EnvironmentViewHolder(view);

        return environmentViewHolder;
    }

    @Override
    public void onBindViewHolder(final EnvironmentViewHolder holder, int position) {
        holder.textView.setText(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchItems(String.valueOf(holder.textView.getText()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class EnvironmentViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public EnvironmentViewHolder(View itemView) {

            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewGestureItem);
        }
    }

    private void switchItems(String item)
    {
        CommandSender sender;

        for(int i = 0; i<Data.ENVIRONMENT.length; i++)
        {
            if(item.equalsIgnoreCase(Data.ENVIRONMENT[i]))
            {
                sender = new CommandSender();
                sender.execute("Environment-" + Data.ENVIRONMENT[i]);
            }
        }
    }
}
