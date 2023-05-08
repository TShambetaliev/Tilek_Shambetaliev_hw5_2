package com.example.tilek_shambetaliev_hw5_2

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("love_table")
data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) : java.io.Serializable
{
    override fun toString(): String {
        return "${firstName}\n ${secondName}\n $percentage\n $result\n\n"
    }
}
