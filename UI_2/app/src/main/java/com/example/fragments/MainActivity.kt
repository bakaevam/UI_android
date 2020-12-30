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
    val orange_tag = "orange tag"
    val blue_tag = "blue tag"
    lateinit var blueFragment: BlueFragment
    lateinit var orangeFragment: OrangeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orangeButton = findViewById(R.id.orange_button)
        blueButton = findViewById(R.id.blue_button)

        if (savedInstanceState != null) {
            orangeFragment = supportFragmentManager.findFragmentByTag(orange_tag) as OrangeFragment
            blueFragment = supportFragmentManager.findFragmentByTag(blue_tag) as BlueFragment
        } else if (savedInstanceState == null) {
            orangeFragment = OrangeFragment()
            blueFragment = BlueFragment()

            supportFragmentManager.beginTransaction()?.apply {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, orangeFragment, orange_tag)
                add(R.id.fragmentContainerView, blueFragment, blue_tag)

                commit()
            }
        }

        orangeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                setPrimaryNavigationFragment(orangeFragment)
                hide(blueFragment)
                show(orangeFragment)

                commit()
            }
        }

        blueButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                setPrimaryNavigationFragment(blueFragment)
                hide(orangeFragment)
                show(blueFragment)

                commit()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        supportFragmentManager.putFragment(outState, "orange tag", orangeFragment)
        supportFragmentManager.putFragment(outState, "blue tag", blueFragment)
    }
}