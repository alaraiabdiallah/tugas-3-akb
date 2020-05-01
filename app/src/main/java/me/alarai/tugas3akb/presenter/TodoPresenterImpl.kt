package me.alarai.tugas3akb.presenter

import android.content.Context
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.alarai.tugas3akb.data_sources.room.AppDB
import me.alarai.tugas3akb.data_sources.room.entities.Todo
import me.alarai.tugas3akb.view.TodoView

class TodoPresenterImpl(val todoView: TodoView, val context: Context): TodoPresenter {

    val db = AppDB.getInstance(context)?.todoDao()

    override fun save(todo: Todo) {
        GlobalScope.launch {
            db?.insert(todo)
        }
        runBlocking {     // but this expression blocks the main thread
            delay(100L)  // ... while we delay for 2 seconds to keep JVM alive
        }
        todoView.onSave()
    }

    override fun load() {
        var data: ArrayList<Todo> = arrayListOf()
        GlobalScope.launch {
            val d = db?.getAll()
            if (d != null) {
                data.addAll(d)
            }
        }
        runBlocking {     // but this expression blocks the main thread
            delay(100L)  // ... while we delay for 2 seconds to keep JVM alive
        }
        todoView.onLoad(data)
    }

    override fun delete(todo: Todo) {
        GlobalScope.launch {
            db?.delete(todo)
        }
        runBlocking {     // but this expression blocks the main thread
            delay(100L)  // ... while we delay for 2 seconds to keep JVM alive
        }
        todoView.onDelete()
    }
}