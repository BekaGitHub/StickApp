package app.dfki.de.stickapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.connect.CommandSender;
import app.dfki.de.stickapp.data.Data;

/**
 * Created by EmpaT on 02.01.2017.
 */

public class BackgroundRecyclerViewAdapter extends RecyclerView.Adapter<BackgroundRecyclerViewAdapter.BackgroundViewHolder> {

    private List<Integer> list;

    public BackgroundRecyclerViewAdapter(List<Integer> list){

        this.list = list;
    }

    @Override
    public BackgroundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.background_recycler_item, parent, false);
        BackgroundViewHolder viewHolder = new BackgroundViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BackgroundViewHolder holder, final int position) {
        holder.itemImage.setImageResource(list.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchItems(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class BackgroundViewHolder extends RecyclerView.ViewHolder{
         ImageView itemImage;

         public BackgroundViewHolder(View itemView) {
            super(itemView);
             itemImage = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    private void switchItems(int bg)
    {
        CommandSender sender = null;

        for(int i = 0; i<Data.BACKGROUND.length; i++)
        {
            if(bg == Data.BACKGROUND[i])
            {
                sender = new CommandSender();
                sender.execute("Background-" + i);
            }
        }
    }
}
