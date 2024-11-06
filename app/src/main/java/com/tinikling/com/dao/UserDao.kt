package com.tinikling.com.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinikling.com.table.User

@Dao
interface UserDao {

    // Insert a new user into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Int): User?
    // Get the points of a user by their ID
    @Query("SELECT points FROM user WHERE id = :id LIMIT 1")
    suspend fun getUserPoints(id: Int): Int?

    // Update only the points field for an existing user
    @Query("UPDATE user SET points = :points WHERE id = :id")
    suspend fun updatePoints(id: Int, points: Int)
}