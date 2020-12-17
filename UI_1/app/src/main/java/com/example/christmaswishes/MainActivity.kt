package com.example.christmaswishes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var img: ImageView
    lateinit var list: TextView
    lateinit var title_text: TextView
    lateinit var button: Button
    lateinit var button_clear: Button
    private var isButtonPressed: Boolean = false
    lateinit var fromEditText: String

    companion object {
        private const val TEXT_KEY = "TEXT_KEY"
        private const val TEXT_TO_IMG_KEY = "TEXT_TO_IMG_KEY"
        private const val TAG = "my logs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        img = findViewById(R.id.imageView)
        list = findViewById(R.id.list)
        title_text = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button_clear = findViewById(R.id.button_clear)

        list.text = """
            Socks
            Sweets
            Christmas Tree
            Candles
            Fireworks
            Mandarins
        """

        button.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                Log.d(TAG, "Repeat button")
                list.isInvisible = true
                img.isInvisible = false
                isButtonPressed = true

                fromEditText = editText.text.toString()

                when (fromEditText.toLowerCase()) {
                    "socks" -> img.setImageResource(R.drawable.socks)
                    "sweets" -> img.setImageResource(R.drawable.sweets)
                    "christmas tree" -> img.setImageResource(R.drawable.tree)
                    "candles" -> img.setImageResource(R.drawable.candles)
                    "fireworks" -> img.setImageResource(R.drawable.fireworks)
                    "mandarins" -> img.setImageResource(R.drawable.mandarins)
                    else -> {
                        img.isInvisible = true
                        list.isInvisible = false
                    }
                }
                title_text.text = "I want $fromEditText"
                it.isEnabled = false
                button_clear.isEnabled = true
            }
        }

        button_clear.setOnClickListener {
            title_text.text = "I want ..."
            button.isEnabled = true
            it.isEnabled = false
            editText.text.clear()
            img.isInvisible = true
            list.isInvisible = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TEXT_KEY, title_text.text.toString())
        outState.putBoolean("IS_BUTTON_PRESSED", isButtonPressed)
        outState.putString(TEXT_TO_IMG_KEY, editText.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun restoreImage(text: String) {
        Log.d(TAG, "restore Image")
        list.isInvisible = true
        img.isInvisible = false

        when (text.toLowerCase()) {
            "socks" -> img.setImageResource(R.drawable.socks)
            "sweets" -> img.setImageResource(R.drawable.sweets)
            "christmas tree" -> img.setImageResource(R.drawable.tree)
            "candles" -> img.setImageResource(R.drawable.candles)
            "fireworks" -> img.setImageResource(R.drawable.fireworks)
            "mandarins" -> img.setImageResource(R.drawable.mandarins)
            else -> {
                img.isInvisible = true
                list.isInvisible = false
            }
        }
        isButtonPressed = false
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        lateinit var text: String
        savedInstanceState.getString(TEXT_KEY)?.let {
            title_text.text = it
        }

        if (savedInstanceState.getBoolean("IS_BUTTON_PRESSED", true)) {
            savedInstanceState.getString(TEXT_TO_IMG_KEY)?.let {
                text = it
            }
            restoreImage(text)
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
}