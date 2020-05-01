package me.alarai.tugas3akb.presenter

import android.content.Context
import me.alarai.tugas3akb.utils.Preferences
import me.alarai.tugas3akb.view.MainView

class MainPresenterImpl(val mainView: MainView, val context: Context): MainPresenter {
    val prefs = Preferences(context)
    override fun saveNama(nama: String) {
        if (!nama.isEmpty()){
            prefs.setNamaPrefs(nama)
            mainView.onSaveNama()
        }else{
            mainView.alertWhenNameEmpty()
        }
    }
}