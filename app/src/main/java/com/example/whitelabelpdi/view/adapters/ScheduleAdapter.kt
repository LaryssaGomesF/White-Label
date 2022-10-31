package com.example.whitelabelpdi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whitelabelpdi.databinding.ItemScheduleBinding
import com.example.whitelabelpdi.view.model.ScheduleEvent

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    private lateinit var onClickListener: (Int) -> Unit
    private var list: MutableList<ScheduleEvent> = mutableListOf()

    class ScheduleViewHolder(
        private val view: ItemScheduleBinding,
        private val onClick: (Int) -> Unit,
        private val contextParent: Context
    ) : RecyclerView.ViewHolder(view.root) {

        fun bind(item: ScheduleEvent) {
            view.apply {
                textViewTitle.text = item.title.plus(item.data)
                textViewDescriptionEvent.text = item.description
                view.item.setOnClickListener {
                    onClick.invoke(item.id)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val itemBinding =
            ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(itemBinding, onClickListener, parent.context)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<ScheduleEvent>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(list: List<ScheduleEvent>) {
        val startIndex = this.list.size
        this.list.addAll(list)
        notifyItemRangeInserted(startIndex, list.size)
    }

    fun setOnClick(click: (Int) -> Unit) {
        this.onClickListener = click
    }

    fun clear() {
        this.list.clear()
        notifyDataSetChanged()
    }
}