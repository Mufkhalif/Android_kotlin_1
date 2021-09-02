package com.example.keyboardinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvKeyboard: RecyclerView
    private var list: ArrayList<Keyboard> = arrayListOf()
    private lateinit var btnUser: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvKeyboard = findViewById(R.id.rv_keyboards)
        rvKeyboard.setHasFixedSize(true)

        btnUser = findViewById(R.id.btn_user)

        list.addAll(KeyboardData.listKeyboard)
        showRecyclerList()

        supportActionBar?.hide()

        btnUser.setOnClickListener(this)
    }

    private fun showRecyclerList() {
        rvKeyboard.layoutManager = LinearLayoutManager(this)
        val listKeyboardAdapter = ListKeyboardAdapter(list)
        rvKeyboard.adapter = listKeyboardAdapter

        listKeyboardAdapter.setOnItemClickCallback(object :
            ListKeyboardAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Keyboard, index: Int) {
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)

                detailIntent.putExtra(DetailActivity.INDEX_DATA, index)
                startActivity(detailIntent)
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_user -> {
                var aboutIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }

}