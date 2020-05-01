package me.alarai.tugas3akb.view

import me.alarai.tugas3akb.data_sources.room.entities.Todo

interface TodoView {
    fun onLoad(todos: List<Todo>)
    fun onSave()
    fun onDelete()
}