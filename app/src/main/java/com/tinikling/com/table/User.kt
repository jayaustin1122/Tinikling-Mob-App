package com.tinikling.com.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var fullName : String,
    var age : Int,
    var email : String,
    var password : String,
    var points : Int,
)