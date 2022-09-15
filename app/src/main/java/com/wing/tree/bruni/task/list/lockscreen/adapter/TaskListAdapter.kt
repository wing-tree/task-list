package com.wing.tree.bruni.task.list.lockscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.wing.tree.bruni.task.list.constant.ZERO
import com.wing.tree.bruni.task.list.databinding.TaskItemBinding

class TaskListAdapter : ListAdapter<TaskListAdapter.Item, TaskListAdapter.ViewHolder>(ItemCallback()) {
    inner class ViewHolder(private val viewBinding: ViewBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: Item) {
            when(item) {
                is Item.Task -> {
                    if (viewBinding is TaskItemBinding) {
                        viewBinding.bind(item)
                    }
                }
            }
        }

        private fun TaskItemBinding.bind(item: Item.Task) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val viewBinding = when(viewType) {
            ViewType.Task.viewType -> TaskItemBinding.inflate(inflater, parent, false)
            else -> throw IllegalArgumentException("$viewType")
        }

        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is Item.Task -> ViewType.Task.viewType
        }
    }

    enum class ViewType(val viewType: Int) {
        Task(ZERO)
    }

    sealed class Item {
        abstract val id: Long

        data class Task(
            override val id: Long,
            val title: String,
            val description: String
        ) : Item()
    }

    private class ItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}