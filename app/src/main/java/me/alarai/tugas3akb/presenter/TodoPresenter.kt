package me.alarai.tugas3akb.presenter

import me.alarai.tugas3akb.data_sources.room.entities.Todo

interface TodoPresenter {
    fun save(todo: Todo)
    fun load()
    fun delete(todo: Todo)
}