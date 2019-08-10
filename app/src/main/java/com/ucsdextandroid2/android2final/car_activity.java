package com.ucsdextandroid2.android2final;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class car_activity extends AppCompatActivity {

    private CarAdapter carAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        DataSources.getInstance().getCars(new DataSources.Callback<List<Car>>() {
            @Override
            public void onDataFetched(List<Car>data){
                Log.d("test","Cars:" + data.size());
            }
        });

        setUpNavView();
    }

    private void setUpNavView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.ai_bottom_nav_view);

        NavController navController = Navigation
                .findNavController(this, R.id.ai_nav_host);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
