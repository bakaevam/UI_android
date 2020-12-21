package com.example.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.utils.ArgumentManager

class ChildOrangeFragment: Fragment(R.layout.child_orange_fragment) {

    lateinit var counter_orange: TextView
    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.child_orange_fragment, container, false)
        textView = view.findViewById(R.id.textView_orange)
        counter_orange = view.findViewById(R.id.counter_orange)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

        val argumentManager = ArgumentManager()
        val counterValue = argumentManager.getCounter(arguments)
        counter_orange.text = "$counterValue"

        textView.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.orangeFragmentContainerView,
                    ChildOrangeFragment::class.java,
                    argumentManager.createArgs(counterValue + 1)
                )
                addToBackStack(null)

                commit()
            }
        }
    }
}