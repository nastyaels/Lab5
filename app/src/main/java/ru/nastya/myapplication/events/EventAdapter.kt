package ru.nastya.myapplication.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nastya.myapplication.models.event.Event
import ru.nastya.myapplication.databinding.EventsItemBinding

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventHolder>() {
    private var data = listOf<Event>()

    class EventHolder private constructor(
        private var binding: EventsItemBinding
        ): RecyclerView.ViewHolder(binding.root) {
            fun bind (item: Event){
                binding.eventName.text = item.title
                binding.eventDescription.text = item.desc
                binding.eventDate.text = item.dateStart.toString()
            }
        companion object{
            fun from(parent: ViewGroup) : EventHolder {
                val binding = EventsItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent,false
                )
                return EventHolder(binding)
            }
        }
    }

    fun refreshEvents(events: List<Event>) {
        this.data = events
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        return EventHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val item = data[position]

        holder.bind(item)
    }


    override fun getItemCount() = data.size

}