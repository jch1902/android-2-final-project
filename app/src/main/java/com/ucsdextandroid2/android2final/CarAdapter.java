package com.ucsdextandroid2.android2final;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<ListViewHolder>{
    private List<? extends Car>items = new ArrayList<>();
    private OnItemClickListener<Car> onItemClickListener;

    @NonNull
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListViewHolder listViewHolder = ListViewHolder.inflate(parent);
        listViewHolder.setClickListener( item -> {
            if(onItemClickListener != null)
                onItemClickListener.onItemClicked(item);
        });

        return listViewHolder;
    }
    public void submitList(@Nullable List<? extends Car> list){
        this.items = list;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener<Car>onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    private Car getItem(int position){
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
