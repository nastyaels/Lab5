package ru.nastya.myapplication.ui.holidays

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nastya.myapplication.R
import ru.nastya.myapplication.MainActivity






class Holidays : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fab = (activity as MainActivity?)!!.getFloatingActionButton()

        if (fab != null) {
            (activity as MainActivity?)!!.hideFloatingActionButton()
        }
        return inflater.inflate(R.layout.fragment_holidays, container, false)
    }

}