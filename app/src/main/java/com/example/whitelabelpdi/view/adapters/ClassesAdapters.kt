package com.example.whitelabelpdi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.databinding.ItemClassesAdapterBinding
import com.example.whitelabelpdi.view.model.ClassesView

class ClassesAdapters() : RecyclerView.Adapter<ClassesAdapters.ClassViewHolder>() {

    private var list: MutableList<ClassesView> = mutableListOf()
    private lateinit var onClickListener: (String) -> Unit

    class ClassViewHolder(
        private val itemBinding: ItemClassesAdapterBinding,
        private val onClick: (String) -> Unit,
        private val contextParent: Context
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(item: ClassesView, index: Int) {
            itemBinding.apply {
                textViewClassesName.text = item.nameClass
                textViewNumberGrade.text = item.numberGradeClass
                textViewSubject.text = item.subjectClass
            }
            itemBinding.item.apply {
                setOnClickListener {
                    onClick.invoke(item.idClass)
                }
                val background =
                    controlColor(generateBackgroundColors(contextParent), index = index)
                itemBinding.item.setCardBackgroundColor(background)
            }
        }


        private fun controlColor(list: List<Int>, index: Int): Int {
            val color: Int = if (index >= list.size) {
                val n = (index / list.size)
                val auxindex = (index - (list.size) * n)
                list[auxindex]
            } else {
                list[index]
            }
            return color
        }

        private fun generateBackgroundColors(context: Context): List<Int> {
            return listOf(
                ContextCompat.getColor(context, R.color.colorPrimary),
                ContextCompat.getColor(context, R.color.colorPrimaryVariant),
                ContextCompat.getColor(context, R.color.colorSecondary),
                ContextCompat.getColor(context, R.color.colorSecondaryVariant),
                ContextCompat.getColor(context, R.color.colorTertiary),
                ContextCompat.getColor(context, R.color.colorTertiaryVariant)
            )

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val itemBinding =
            ItemClassesAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassViewHolder(itemBinding, onClickListener, parent.context)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<ClassesView>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(list: List<ClassesView>) {
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