package me.alarai.tugas3akb.view

import android.view.View

interface MainView {
    fun NextBtnClickListener(v: View)
    fun onSaveNama()
    fun alertWhenNameEmpty()
}