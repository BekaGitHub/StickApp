package app.dfki.de.stickapp.recyclerviewadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.connect.CommandSender;

/**
 * Created by EmpaT on 02.01.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ColorViewHolder> {

    private List<String> colorItemList;
    private Context context;

    public RecyclerViewAdapter(List<String> colorItemList){

        this.colorItemList = colorItemList;
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclter_item_view, parent, false);
        ColorViewHolder viewHolder = new ColorViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ColorViewHolder holder, int position) {
        holder.itemText.setText(colorItemList.get(position));
        if(position == 0 || position == 1 || position == 2)
            holder.itemImage.setImageResource(R.mipmap.angry);
        else if(position == 3)
            holder.itemImage.setImageResource(R.mipmap.angrysmall);
        else if(position == 4)
            holder.itemImage.setImageResource(R.mipmap.contempt);
        else if(position == 5)
            holder.itemImage.setImageResource(R.mipmap.contempt);
        else if(position == 6)
            holder.itemImage.setImageResource(R.mipmap.disgusted);
        else if(position == 7)
            holder.itemImage.setImageResource(R.mipmap.embarrassed);
        else if(position == 8)
            holder.itemImage.setImageResource(R.mipmap.excited);
        else if(position == 9)
            holder.itemImage.setImageResource(R.mipmap.fear);
        else if(position == 10)
            holder.itemImage.setImageResource(R.mipmap.happy);
        else if(position == 11)
            holder.itemImage.setImageResource(R.mipmap.sad);
        else if(position == 12)
            holder.itemImage.setImageResource(R.mipmap.happy);
        else if(position == 13)
            holder.itemImage.setImageResource(R.mipmap.surprised);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchItems(String.valueOf(holder.itemText.getText()));
            }
        });
    }

    @Override
    public int getItemCount() {

        return colorItemList.size();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder{
         TextView itemText;
         ImageView itemImage;
         View itemView;

         public ColorViewHolder(View itemView) {
            super(itemView);
             this.itemView = itemView;
             itemText = (TextView) itemView.findViewById(R.id.recycler_itemText);
             itemImage = (ImageView) itemView.findViewById(R.id.recycler_itemImage);
        }
    }

    private void switchItems(String item)
    {
        CommandSender sender;

        switch (item)
        {
            case "Angry":
                sender = new CommandSender();
                sender.execute("Emotion-Angry");
                break;
            case "Angry2":
                sender = new CommandSender();
                sender.execute("Emotion-Angry2");
                break;
            case "Angry3":
                sender = new CommandSender();
                sender.execute("Emotion-Angry3");
                break;
            case "AngrySmall":
                sender = new CommandSender();
                sender.execute("Emotion-AngrySmall");
                break;
            case "Arrogant":
                sender = new CommandSender();
                sender.execute("Emotion-Arrogant");
                break;
            case "Contempt":
                sender = new CommandSender();
                sender.execute("Emotion-Contempt");
                break;
            case "Disgusted":
                sender = new CommandSender();
                sender.execute("Emotion-Disgusted");
                break;
            case "Embarrassed":
                sender = new CommandSender();
                sender.execute("Emotion-Embarrassed");
                break;
            case "Excited":
                sender = new CommandSender();
                sender.execute("Emotion-Excited");
                break;
            case "Fear":
                sender = new CommandSender();
                sender.execute("Emotion-Fear");
                break;
            case "Happy":
                sender = new CommandSender();
                sender.execute("Emotion-Happy");
                break;
            case "Sad":
                sender = new CommandSender();
                sender.execute("Emotion-Sad");
                break;
            case "Smile":
                sender = new CommandSender();
                sender.execute("Emotion-Smile");
                break;
            case "Surprised":
                sender = new CommandSender();
                sender.execute("Emotion-Surprised");
                break;
        }
    }
}
