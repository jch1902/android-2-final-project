package com.ucsdextandroid2.android2final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleView;
    private Car currentCar;
    private OnItemClickListener<Car> clickListener;

    public static ListViewHolder inflate(@NonNull ViewGroup parent) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false));
    }
    private ListViewHolder(@NonNull View itemView ){
        super(itemView);

        imageView = itemView.findViewById(R.id.vsi_image);
        titleView = itemView.findViewById((R.id.vsi_title));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null && currentCar != null)
                    clickListener.onItemClicked(currentCar);
            }
        });
    }
    public void bind (Car car){
        this.currentCar = car;

 //       Picasso.get().load(currentCar.getPhoto()).into(imageView);
        titleView.setText(currentCar.getCarClass() + " " + currentCar.getCarType() + " " + currentCar.getCarDesign());
    }
    public void setClickListener(OnItemClickListener<Car>clickListener){
        this.clickListener = clickListener;
    }
}
