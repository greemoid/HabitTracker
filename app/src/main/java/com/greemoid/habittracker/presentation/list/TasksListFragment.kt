package com.greemoid.habittracker.presentation.list

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentTasksListBinding
import com.greemoid.habittracker.presentation.core.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksListFragment :
    BaseFragment<TasksListViewModel, FragmentTasksListBinding>(FragmentTasksListBinding::inflate) {
    override val viewModel: TasksListViewModel by viewModels()

    override fun init() {
        binding.fbtnAdd.navigate(R.id.action_tasksListFragment_to_addTaskFragment)
        binding.btnAdd.navigate(R.id.action_tasksListFragment_to_addTaskFragment)

        viewModel.getAllHabits()
        val adapter = TasksListAdapter()
        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable("habit", it)
            findNavController().navigate(R.id.action_tasksListFragment_to_taskFragment, bundle)
        }
        binding.tvDate.text = viewModel.getToday()
        when(viewModel.getDayOfWeek()) {
            1 -> binding.cbSunday.isChecked = true
            2 -> binding.cbMonday.isChecked = true
            3 -> binding.cbTuesday.isChecked = true
            4 -> binding.cbWednesday.isChecked = true
            5 -> binding.cbThursday.isChecked = true
            6 -> binding.cbFriday.isChecked = true
            7 -> binding.cbSaturday.isChecked = true
        }
        binding.recyclerView.adapter = adapter
        viewModel.liveData.observe(this) { list ->
            adapter.differ.submitList(list.asReversed())
        }
    }


}