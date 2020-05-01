package me.alarai.tugas3akb.data_sources.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import me.alarai.tugas3akb.data_sources.room.entities.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<Todo>

    @Insert
    fun insert(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}