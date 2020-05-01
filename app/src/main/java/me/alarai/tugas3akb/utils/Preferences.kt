package me.alarai.tugas3akb.utils

import android.content.Context
import me.alarai.tugas3akb.R

const val PREFS_NAMA = "NAMA"

class Preferences(val context: Context) {
    val prefs = context.getSharedPreferences(R.string.prefs_key.toString(), Context.MODE_PRIVATE)
    val prefsEditor = prefs.edit()
    fun getNamaPrefs(): String? = prefs.getString(PREFS_NAMA, UtilStatic.DEFAULT_STRING)
    fun setNamaPrefs(nama: String){
        prefsEditor.putString(PREFS_NAMA, nama)
        prefsEditor.apply()
    }
}