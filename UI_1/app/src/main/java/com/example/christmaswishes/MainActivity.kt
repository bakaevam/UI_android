package com.example.christmaswishes

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var img: ImageView
    lateinit var listTextViews: LinearLayout
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
        title_text = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button_clear = findViewById(R.id.button_clear)
        listTextViews = findViewById(R.id.linearLayout)

        button.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                listTextViews.isInvisible = true
                Log.d(TAG, "Repeat button")
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
            listTextViews.isInvisible = false
            it.isEnabled = false
            editText.text.clear()
            img.isInvisible = true
            isButtonPressed = false
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
        listTextViews.isInvisible = true
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
            }
        }
        button.isEnabled = false
        button_clear.isEnabled = true
        isButtonPressed = true
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