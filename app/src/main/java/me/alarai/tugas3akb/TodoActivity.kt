package me.alarai.tugas3akb

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_todo.*
import me.alarai.tugas3akb.adapter.TodoListAdapter
import me.alarai.tugas3akb.data_sources.room.entities.Todo
import me.alarai.tugas3akb.presenter.TodoPresenter
import me.alarai.tugas3akb.presenter.TodoPresenterImpl
import me.alarai.tugas3akb.utils.Preferences
import me.alarai.tugas3akb.view.TodoView

class TodoActivity : AppCompatActivity(), TodoView {

    lateinit var presenter: TodoPresenter
    lateinit var adapter: TodoListAdapter
    var todoItems: ArrayList<Todo> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        val prefs = Preferences(baseContext)
        supportActionBar?.setTitle("Hi ${prefs.getNamaPrefs()}")
        presenter = TodoPresenterImpl(this, baseContext)
        adapter = TodoListAdapter(todoItems, baseContext)
        todo_list.layoutManager = LinearLayoutManager(this)
        todo_list.adapter = adapter
        adapter.onItemClick = { todo -> presenter.delete(todo) }

        add_btn.setOnClickListener {
            showAddDialog()
        }

        presenter.load()
    }

    override fun onLoad(todos: List<Todo>) {
        println(todos.toString())
        todoItems.clear()
        todoItems.addAll(todos)
        adapter.notifyDataSetChanged()
    }

    override fun onSave() {
        presenter.load()
    }

    override fun onDelete() {
        presenter.load()
    }

    fun showAddDialog() {
        // custom dialog
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_task)
        dialog.setTitle("Add new Task")
        val edtName = dialog.findViewById<EditText>(R.id.edt_name)
        val edtDesc = dialog.findViewById<EditText>(R.id.edt_desc)
        val saveBtn = dialog.findViewById<Button>(R.id.save_btn)

        saveBtn.setOnClickListener {
            if(!edtName.text.isEmpty() && !edtDesc.text.isEmpty()){
                presenter.save(
                    Todo(
                        name = edtName.text.toString(),
                        desc = edtDesc.text.toString()
                    )
                )
            }
            dialog.dismiss()
        }

        dialog.show()
    }
}
