package ru.nastya.myapplication.ui.events

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nastya.myapplication.models.event.Event
import ru.nastya.myapplication.models.event.EventObject

class EventReminderViewModel : ViewModel() {
    private val events: MutableLiveData<List<Event>> = MutableLiveData()
    init {
        events.value = EventObject.getEvents()
    }

    fun getListsEvents() = events

}