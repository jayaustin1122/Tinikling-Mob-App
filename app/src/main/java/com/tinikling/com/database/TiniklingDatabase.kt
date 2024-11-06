package com.tinikling.com.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tinikling.com.dao.UserDao
import com.tinikling.com.table.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class TiniklingDatabase  : RoomDatabase() {
    abstract fun getUser(): UserDao

    companion object {
        @Volatile
        private var instance: TiniklingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, TiniklingDatabase::class.java, "tinikling.db"
        ).fallbackToDestructiveMigration() // This will allow for destructive migrations
            .build()


    }
}