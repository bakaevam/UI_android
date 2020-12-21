package com.example.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.utils.ArgumentManager

class BlueFragment: Fragment(R.layout.blue_fragment) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.blue_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // super.onViewCreated(view, savedInstanceState)

        val blueFragmentChild = ChildBlueFragment()
        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            add(R.id.blueFragmentContainerView, blueFragmentChild)
            addToBackStack(null)

            commit()
        }
    }
}