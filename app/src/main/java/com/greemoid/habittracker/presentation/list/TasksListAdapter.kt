package com.greemoid.habittracker.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.habittracker.R
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.databinding.TaskItemLayoutBinding
import com.greemoid.habittracker.presentation.core.enums.Colors
import com.greemoid.habittracker.presentation.core.enums.Icons
import com.greemoid.habittracker.presentation.update.UpdateViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TasksListAdapter @Inject constructor(
    val updateViewModel: UpdateViewModel,
    val viewModel: TasksListViewModel,
) :
    RecyclerView.Adapter<TasksListAdapter.TasksListViewHolder>() {

    inner class TasksListViewHolder(private val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(habit: HabitDbModel) {
            with(binding) {
                checkBox.isChecked = isChecked(habit.date)

                val color: Int = when (habit.color) {
                    Colors.BLUE.toString() -> R.color.light_blue
                    Colors.PURPLE.toString() -> R.color.purple
                    Colors.LIGHT_ORANGE.toString() -> R.color.light_orange
                    Colors.PELOROUS.toString() -> R.color.pelorous
                    Colors.ORANGE.toString() -> R.color.orange
                    Colors.SEA.toString() -> R.color.light_sea
                    Colors.RED.toString() -> R.color.red
                    Colors.PINK.toString() -> R.color.pink
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

                if (isChecked(habit.date)) {
                    linItem.setBackgroundResource(R.color.background_for_other_views)
                } else {
                    linItem.setBackgroundResource(color)
                }
                ivIcon.setImageResource(icon)

                binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        linItem.setBackgroundResource(R.color.background_for_other_views)
                        val totallyDays = habit.totallyDays + 1
                        val streakDays =
                            if (habit.streakDays == 0) {
                                1
                            } else if (habit.streakDays != 0 && habit.date == getYesterday()) {
                                habit.streakDays + 1
                            } else {
                                habit.streakDays
                            }
                        val habitModel = HabitDbModel(
                            id = habit.id,
                            title = habit.title,
                            icon = habit.icon,
                            color = habit.color,
                            date = getCurrentTime(),
                            totallyDays = totallyDays,
                            streakDays = streakDays,
                            doOnMonday = habit.doOnMonday,
                            doOnTuesday = habit.doOnTuesday,
                            doOnWednesday = habit.doOnWednesday,
                            doOnThursday = habit.doOnThursday,
                            doOnFriday = habit.doOnFriday,
                            doOnSaturday = habit.doOnSaturday,
                            doOnSunday = habit.doOnSunday,
                            partOfDay = habit.partOfDay
                        )
                        updateViewModel.update(habitModel)
                    } else {
                        linItem.setBackgroundResource(color)
                        val totallyDays = if (habit.totallyDays > 0) habit.totallyDays - 1 else 0
                        val streakDays =
                            if (habit.streakDays > 0) habit.streakDays - 1 else 0
                        val habitModel = HabitDbModel(
                            id = habit.id,
                            title = habit.title,
                            icon = habit.icon,
                            color = habit.color,
                            date = "cancelled",
                            totallyDays = totallyDays,
                            streakDays = streakDays,
                            doOnMonday = habit.doOnMonday,
                            doOnTuesday = habit.doOnTuesday,
                            doOnWednesday = habit.doOnWednesday,
                            doOnThursday = habit.doOnThursday,
                            doOnFriday = habit.doOnFriday,
                            doOnSaturday = habit.doOnSaturday,
                            doOnSunday = habit.doOnSunday,
                            partOfDay = habit.partOfDay
                        )
                        updateViewModel.update(habitModel)
                    }

                }

                itemView.setOnClickListener {
                    onItemClickListener?.let { it(habit) }
                }
            }
        }

        private fun isChecked(date: String): Boolean {
            return date == getCurrentTime()
        }

        private fun getCurrentTime(): String {
            val time = Calendar.getInstance().time
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return formatter.format(time)
        }

        //todo yest
        private fun getYesterday(): String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, -1)
            return dateFormat.format(calendar.time)
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

    private val differCallback = object : DiffUtil.ItemCallback<HabitDbModel>() {
        override fun areItemsTheSame(oldItem: HabitDbModel, newItem: HabitDbModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: HabitDbModel, newItem: HabitDbModel): Boolean {
            return oldItem == newItem
        }
    }

    fun setOnItemClickListener(listener: (HabitDbModel) -> Unit) {
        onItemClickListener = listener
    }

    val differ = AsyncListDiffer(this, differCallback)
}


var onItemClickListener: ((HabitDbModel) -> Unit)? = null