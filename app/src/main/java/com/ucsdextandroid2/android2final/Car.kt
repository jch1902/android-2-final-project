package com.ucsdextandroid2.android2final

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
class Car(

    @field:SerializedName("class")
    @PrimaryKey
    @ColumnInfo(name = "class")
    var carClass: String,

    @field:SerializedName("type")
    @ColumnInfo(name = "type")
    var carType: String,

    @field:SerializedName("design")
    @ColumnInfo(name = "design")
    var carDesign: String

)