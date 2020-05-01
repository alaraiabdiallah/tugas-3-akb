package me.alarai.tugas3akb.data_sources.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.alarai.tugas3akb.data_sources.room.daos.TodoDao
import me.alarai.tugas3akb.data_sources.room.entities.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun todoDao(): TodoDao?

    companion object {
        private var instance: AppDB? = null
        private val db_name = "tugas3DB.db"
        fun getInstance(context: Context?): AppDB? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context!!,
                    AppDB::class.java, db_name
                ).build()
            }
            return instance
        }
    }
}

