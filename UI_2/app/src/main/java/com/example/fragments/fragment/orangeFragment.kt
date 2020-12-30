package com.example.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R


class OrangeFragment : Fragment(R.layout.orange_fragment) {
    val orange_child_tag = "orange child tag"
    lateinit var orangeFragmentChild: ChildOrangeFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState != null) {
            orangeFragmentChild = childFragmentManager.getFragment(savedInstanceState, orange_child_tag) as ChildOrangeFragment
        } else if (savedInstanceState == null) {
            orangeFragmentChild = ChildOrangeFragment()
            childFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.orangeFragmentContainerView, orangeFragmentChild)
                addToBackStack(null)

                commit()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        childFragmentManager.putFragment(outState, orange_child_tag, orangeFragmentChild)
    }
}