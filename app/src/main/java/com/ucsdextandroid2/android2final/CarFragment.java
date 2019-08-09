package com.ucsdextandroid2.android2final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarFragment extends Fragment {

    private CarAdapter carAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        carAdapter = new CarAdapter();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.car_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.am_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(carAdapter);
        carAdapter.setOnItemClickListener(new OnItemClickListener<Car>() {
            @Override
            public void onItemClicked(Car item) {

            }
        });
        //Everything works fine up until this method
        DataSources.getInstance().getCars(new DataSources.Callback<List<Car>>() {
            @Override
            public void onDataFetched(List<Car> data) {
                carAdapter.submitList(data);
            }
        });
    }
}
