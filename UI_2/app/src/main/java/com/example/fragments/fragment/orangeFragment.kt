package com.example.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R


class OrangeFragment : Fragment(R.layout.orange_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.orange_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

        val orangeFragmentChild = ChildOrangeFragment()
        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            add(R.id.orangeFragmentContainerView, orangeFragmentChild)
            addToBackStack(null)

            commit()
        }
    }
}