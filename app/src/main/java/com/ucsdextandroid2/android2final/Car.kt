package com.ucsdextandroid2.android2final

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
class Car(

    @field:SerializedName("MakeName")
    @PrimaryKey
    @ColumnInfo(name = "MakeName")
    var mfrName: String,

    @field:SerializedName("VehicleTypeName")
    @ColumnInfo(name = "VehicleTypeName")
    var vType: String


)