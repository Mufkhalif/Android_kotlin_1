package com.example.keyboardinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class DetailUserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        supportActionBar?.hide()

        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back -> {
                var homeIntent = Intent(this@DetailUserActivity, MainActivity::class.java)
                startActivity(homeIntent)
            }
        }
    }
}