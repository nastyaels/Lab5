package ru.nastya.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventReminderViewModel : ViewModel() {
    private val events: MutableLiveData<List<Event>> = MutableLiveData()
    init {
        events.value = EventObject.getEvents()
    }

    fun getListsEvents() = events

}