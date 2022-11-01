package com.greemoid.habittracker.presentation.task

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.habittracker.R
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.databinding.FragmentTaskBinding
import com.greemoid.habittracker.presentation.core.BaseFragment
import com.greemoid.habittracker.presentation.core.enums.PartOfDay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment :
    BaseFragment<TaskViewModel, FragmentTaskBinding>(FragmentTaskBinding::inflate) {
    override val viewModel: TaskViewModel by viewModels()


    override fun init() {
        binding.btnGoBack.navigate(R.id.action_taskFragment_to_tasksListFragment)
        val args: TaskFragmentArgs by navArgs()
        binding.tvNameOfTheHabit.text = args.habit.title
        binding.tvTotalNumber.text = args.habit.totallyDays.toString()
        binding.tvStreak.text = args.habit.streakDays.toString()
        when (args.habit.partOfDay) {
            PartOfDay.DAY.toString() -> binding.tvPartOfDay.text = getString(R.string.day)
            PartOfDay.MORNING.toString() -> binding.tvPartOfDay.text = getString(R.string.morning)
            PartOfDay.EVENING.toString() -> binding.tvPartOfDay.text = getString(R.string.evening)
            PartOfDay.DOESNTMATTER.toString() -> binding.tvPartOfDay.text =
                getString(R.string.doesnt_matter)
        }

        if (allDays(args.habit)) binding.tvDays.text =
            getString(R.string.every_day) else binding.tvDays.text =
            "${if (args.habit.doOnMonday) getString(R.string.monday) + ", " else ""}" +
                    "${if (args.habit.doOnTuesday) getString(R.string.tuesday) + ", " else ""}" +
                    "${if (args.habit.doOnWednesday) getString(R.string.wednesday) + ", " else ""}" +
                    "${if (args.habit.doOnThursday) getString(R.string.thursday) + ", " else ""}" +
                    "${if (args.habit.doOnFriday) getString(R.string.friday) + ", " else ""}" +
                    "${if (args.habit.doOnSaturday) getString(R.string.saturday) + ", " else ""}" +
                    "${if (args.habit.doOnSunday) getString(R.string.sunday) else ""}"

        binding.btnDelete.setOnClickListener {
            viewModel.deleteHabit(args.habit)
            findNavController().navigate(R.id.action_taskFragment_to_tasksListFragment)
        }
        binding.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("habit", args.habit)
            findNavController().navigate(R.id.action_taskFragment_to_updateTaskFragment, bundle)
        }
    }


    private fun allDays(habit: HabitDbModel): Boolean =
        habit.doOnMonday && habit.doOnTuesday && habit.doOnWednesday && habit.doOnThursday
                && habit.doOnFriday && habit.doOnSaturday && habit.doOnSunday
}