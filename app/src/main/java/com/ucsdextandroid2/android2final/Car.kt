package com.ucsdextandroid2.android2final

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
class Car(

    @field:SerializedName("Make_Name")
    @PrimaryKey
    @ColumnInfo(name = "Make_Name")
    var mfrName: String,

    @field:SerializedName("Model_Name")
    @ColumnInfo(name = "Model_Name")
    var vType: String


)