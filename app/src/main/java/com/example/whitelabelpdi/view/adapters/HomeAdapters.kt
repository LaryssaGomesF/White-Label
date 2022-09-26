package com.example.whitelabelpdi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whitelabelpdi.databinding.ItemHomeAdapterBinding
import com.example.whitelabelpdi.view.model.HomeItemView

class HomeAdapters : RecyclerView.Adapter<HomeAdapters.HomeItemViewHolder>() {

    private var list: MutableList<HomeItemView> = mutableListOf()
    private lateinit var onClickListener: (String) -> Unit

    class HomeItemViewHolder(
        private val itemBinding: ItemHomeAdapterBinding,
        private val onClick: (String) -> Unit,
        private val contextParent: Context
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(item: HomeItemView) {
            itemBinding.apply {
                imageViewIconFeature.setImageDrawable(
                    ContextCompat.getDrawable(
                        contextParent,
                        item.icon
                    )
                )
                textViewTitleFeature.text = item.title
            }
            itemBinding.item.apply {
                setOnClickListener {
                    onClick.invoke(item.title)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val itemBinding =
            ItemHomeAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeItemViewHolder(itemBinding, onClickListener, parent.context)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<HomeItemView>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(list: List<HomeItemView>) {
        val startIndex = this.list.size
        this.list.addAll(list)
        notifyItemRangeInserted(startIndex, list.size)
    }

    fun setOnClick(click: (String) -> Unit) {
        this.onClickListener = click
    }

    fun clear() {
        this.list.clear()
        notifyDataSetChanged()
    }
}