package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragments.fragment.BlueFragment
import com.example.fragments.fragment.OrangeFragment

class MainActivity : AppCompatActivity() {
    lateinit var orangeButton: Button
    lateinit var blueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orangeButton = findViewById(R.id.orange_button)
        blueButton = findViewById(R.id.blue_button)

        val orangeFragment = OrangeFragment()
        val blueFragment = BlueFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, orangeFragment)
                addToBackStack("orangeFragmentContainerView")

                add(R.id.fragmentContainerView, blueFragment)
                addToBackStack("blueFragmentContainerView")

                commit()
            }
        }

        orangeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                setPrimaryNavigationFragment(orangeFragment)
                hide(blueFragment)
                show(orangeFragment)
                addToBackStack(null)

                commit()
            }
        }

        blueButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                setPrimaryNavigationFragment(blueFragment)
                hide(orangeFragment)
                show(blueFragment)
                addToBackStack(null)

                commit()
            }
        }
    }
}