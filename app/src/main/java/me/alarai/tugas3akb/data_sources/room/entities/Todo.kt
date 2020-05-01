package me.alarai.tugas3akb.data_sources.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="desc") val desc: String)