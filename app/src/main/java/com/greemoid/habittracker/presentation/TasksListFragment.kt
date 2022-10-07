package com.greemoid.habittracker.presentation

import androidx.fragment.app.viewModels
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentTasksListBinding
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
        binding.recyclerView.adapter = adapter
        viewModel.liveData.observe(this) { list ->
            adapter.differ.submitList(list.asReversed())
        }
    }


}