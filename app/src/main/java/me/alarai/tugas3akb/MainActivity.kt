package me.alarai.tugas3akb

/*
* NIM : 10116006
* Nama: Ala Rai AbdiAllah
* Kelas: IF-6K
* Tanggal Pengerjaan : 01 Mei 2020
* Deskripsi Pekerjaan: Implementasi sederhana shared preference & penggunaan room menggunakan MVP
* */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.alarai.tugas3akb.presenter.MainPresenter
import me.alarai.tugas3akb.presenter.MainPresenterImpl
import me.alarai.tugas3akb.utils.Preferences
import me.alarai.tugas3akb.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this, baseContext)
        next_btn.setOnClickListener{ NextBtnClickListener(it) }
    }

    override fun NextBtnClickListener(v: View) {
        val nama = edt_nama.text.toString()
        presenter.saveNama(nama)
    }

    override fun onSaveNama() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    override fun alertWhenNameEmpty() {
        val toast = Toast.makeText(applicationContext, R.string.nama_empty_txt, Toast.LENGTH_SHORT)
        toast.show()
    }
}
