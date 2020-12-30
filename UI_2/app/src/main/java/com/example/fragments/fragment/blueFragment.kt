package com.example.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.utils.ArgumentManager

class BlueFragment : Fragment(R.layout.blue_fragment) {
    lateinit var blueFragmentChild: ChildBlueFragment
    val blue_child_tag = "blue child tag"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        blueFragmentChild = ChildBlueFragment()


        if (savedInstanceState != null) {
            blueFragmentChild = childFragmentManager.getFragment(savedInstanceState, blue_child_tag) as ChildBlueFragment
        } else if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.blueFragmentContainerView, blueFragmentChild)
                addToBackStack(null)

                commit()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        childFragmentManager.putFragment(outState, blue_child_tag, blueFragmentChild)
    }
}