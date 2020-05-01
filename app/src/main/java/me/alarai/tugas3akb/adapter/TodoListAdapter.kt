package me.alarai.tugas3akb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_list_item.view.*
import me.alarai.tugas3akb.R
import me.alarai.tugas3akb.data_sources.room.entities.Todo

class TodoListAdapter(val items : List<Todo>, val context: Context) : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    var onItemClick: ((Todo) -> Unit)? = null
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder?.todo_name?.text = item?.name
        holder?.todo_desc?.text = item?.desc
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val todo_name = view.todo_name
        val todo_desc = view.todo_desc
        init {
            view.del_btn.setOnClickListener {
                onItemClick?.invoke(items.get(adapterPosition))
            }
        }
    }
}

