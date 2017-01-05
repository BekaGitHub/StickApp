package app.dfki.de.stickapp.recyclerviewadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.dfki.de.stickapp.R;

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
        holder.colorItemName.setText(colorItemList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switchItems(String.valueOf(holder.colorItemName.getText()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return colorItemList.size();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder{
         TextView colorItemName;
         View itemView;

         public ColorViewHolder(View itemView) {
            super(itemView);
             this.itemView = itemView;
             colorItemName = (TextView) itemView.findViewById(R.id.recycler_item);
        }
    }

    /*private void switchItems(String item)
    {
        Intent intent;

        switch (item)
        {
            case "Head":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorHead");
                context.startActivity(intent);
                break;
            case "Hair":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorHair");
                context.startActivity(intent);
                break;
            case "Body":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorBody");
                context.startActivity(intent);
                break;
            case "Limbs":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorLimbs");
                context.startActivity(intent);
                break;
            case "Shoes":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorShoes");
                context.startActivity(intent);
                break;
            case "Lips":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorLips");
                context.startActivity(intent);
                break;
            case "Eye":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorEye");
                context.startActivity(intent);
                break;
            case "Brow":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorBrow");
                context.startActivity(intent);
                break;
            case "Nose":
                intent = new Intent(context, EmotionActyvity.class);
                intent.putExtra("bodyPart", "ColorNose");
                context.startActivity(intent);
                break;
        }
    }*/
}
