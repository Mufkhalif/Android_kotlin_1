package com.example.keyboardinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val INDEX_DATA = "INDEX_KEYBOARD"
    }

    private var currentData: Keyboard = Keyboard()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        val coverImage: ImageView = findViewById(R.id.cover_image)
        val title: TextView = findViewById(R.id.title_detail)
        val desc: TextView = findViewById(R.id.desc_detail)
        val productNumber: TextView = findViewById(R.id.product_number)
        val structure: TextView = findViewById(R.id.structure)
        val triggerSwitch: TextView = findViewById(R.id.trigger_switch)
        val connectionInterface: TextView = findViewById(R.id.connection_interface)
        val keycapMaterial: TextView = findViewById(R.id.keycap_material)
        val outputNumber: TextView = findViewById(R.id.output_number)
        val dimensions: TextView = findViewById(R.id.dimensions)
        val header: TextView = findViewById(R.id.header_name_detail)

        val indexData = intent.getIntExtra(INDEX_DATA, 0)

        currentData = KeyboardData.listKeyboard[indexData]

        header.text = currentData.name
        coverImage.setImageResource(currentData.photoUrl)

        title.text = currentData.name
        desc.text = currentData.desc

        productNumber.text = currentData.spec.productNumber
        structure.text = currentData.spec.structure
        triggerSwitch.text = currentData.spec.triggerSwitch
        connectionInterface.text = currentData.spec.connectionInterface
        keycapMaterial.text = currentData.spec.keycapMaterial
        outputNumber.text = currentData.spec.output_number
        dimensions.text = currentData.spec.dimensions

    }


}