package ru.nastya.myapplication.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager


import ru.nastya.myapplication.databinding.FragmentEventsBinding


class Events : Fragment() {

    private lateinit var binding: FragmentEventsBinding
    private val viewModel: EventReminderViewModel by lazy { ViewModelProvider(this).get(
        EventReminderViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var adapter = EventAdapter()
        binding = FragmentEventsBinding.inflate(inflater)
        binding.eventList.layoutManager = LinearLayoutManager(requireContext())
        binding.eventList.adapter = adapter
        viewModel.getListsEvents().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.refreshEvents(it)
            }
        })
        return binding.root
    }

}