package com.ucsdextandroid2.android2final

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)
        DataSources.getInstance().getCars(object : DataSources.Callback<List<Car>> {
            override fun onDataFetched(data: List<Car>?) {
                Log.d("test", "Cars:"+ data?.size)
            }
        });
    }
}
