package com.ucsdextandroid2.android2final;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class carHolder {
    @SerializedName("cars")
    private List<Car> cars;
    public List<Car> getCars() {return cars;}

    public void setCars(List<Car> meals) {
        this.cars = cars;
    }
}
