package com.example.christmaswishes

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var img: ImageView
    lateinit var list: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        img = findViewById(R.id.imageView)
        list = findViewById(R.id.list)
        button = findViewById(R.id.button)

        list.setText("""
            Socks
            Sweets
            Christmas Tree
            Candles
            Fireworks
            Mandarins
        """)

       /* button.setOnClickListener{
            list.isInvisible = true
            img.isInvisible = false

            var fromEditText = editText.text.toString()

            when(fromEditText) {
                "Socks" -> img.setImageURI(Uri.parse("https:///cdn.shopify.com/s/files/1/1872/4935/products/4697951522_82857126_512x512.jpg?v=1548170941"))
            }

        }*/
    }
}