package com.greemoid.habittracker.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.TaskItemLayoutBinding
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.presentation.core.enums.Colors
import com.greemoid.habittracker.presentation.core.enums.Icons

class TasksListAdapter : RecyclerView.Adapter<TasksListAdapter.TasksListViewHolder>() {
    class TasksListViewHolder(private val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(habit: HabitModel) {
            with(binding) {
                val color: Int = when (habit.color) {
                    Colors.BLUE.toString() -> R.color.light_blue
                    Colors.GREEN.toString() -> R.color.light_green
                    Colors.LIGHT_ORANGE.toString() -> R.color.light_orange
                    Colors.PELOROUS.toString() -> R.color.pelorous
                    Colors.ORANGE.toString() -> R.color.light_sea
                    Colors.SEA.toString() -> R.color.orange
                    Colors.RED.toString() -> R.color.red
                    Colors.BROWN.toString() -> R.color.light_brown
                    else -> R.color.light_blue
                }

                val icon: Int = when (habit.icon) {
                    Icons.BOOK.toString() -> R.drawable.ic_book_checked
                    Icons.MEDITATION.toString() -> R.drawable.ic_meditation_checked
                    Icons.MONEY.toString() -> R.drawable.ic_money_checked
                    Icons.NO_FOOD.toString() -> R.drawable.ic_no_food_checked
                    Icons.NOTE.toString() -> R.drawable.ic_note_checked
                    Icons.PALETTE.toString() -> R.drawable.ic_palette_checked
                    Icons.LAPTOP.toString() -> R.drawable.ic_laptop_checked
                    Icons.RUN.toString() -> R.drawable.ic_run_checked
                    Icons.SCHOOL.toString() -> R.drawable.ic_school_checked
                    Icons.SPORT.toString() -> R.drawable.ic_sport_checked
                    else -> R.drawable.ic_book
                }
                tvHabitTitle.text = habit.title
                linItem.setBackgroundResource(color)
                ivIcon.setImageResource(icon)

                itemView.setOnClickListener {
                    onItemClickListener?.let { it(habit) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksListViewHolder {
        val binding = TaskItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return TasksListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<HabitModel>() {
        override fun areItemsTheSame(oldItem: HabitModel, newItem: HabitModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: HabitModel, newItem: HabitModel): Boolean {
            return oldItem == newItem
        }
    }

    fun setOnItemClickListener(listener: (HabitModel) -> Unit) {
        onItemClickListener = listener
    }

    val differ = AsyncListDiffer(this, differCallback)
}


var onItemClickListener: ((HabitModel) -> Unit)? = null