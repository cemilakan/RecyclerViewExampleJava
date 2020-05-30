package net.kisacasi.recyclviewexamplejava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.AdapterViewHolder> {
    private List<RvItem> responseList;
    private ClickedItem clickedItem;

    public interface ClickedItem{
        void clickedItem(RvItem clickedRvItem);

    }
    RvAdapter(List<RvItem> responseList,ClickedItem clickedItem){
        this.responseList=responseList;
        this.clickedItem=clickedItem;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        RvItem currentValue= responseList.get(position);
        holder.item_image.setImageResource(currentValue.getImageResource());
        holder.item_title.setText(currentValue.getTitle());
        holder.item_subtitle.setText(currentValue.getSubTitle());
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout item_parent;
        ImageView item_image;
        TextView item_title;
        TextView item_subtitle;

        AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            item_parent=itemView.findViewById(R.id.rv_item_root);
            item_image=itemView.findViewById(R.id.rv_item_img);
            item_title=itemView.findViewById(R.id.rv_item_title);
            item_subtitle=itemView.findViewById(R.id.rv_item_subtitle);
            item_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickedItem.clickedItem(responseList.get(getAdapterPosition()));
                }
            });
        }

    }



    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
