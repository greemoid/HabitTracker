package com.greemoid.habittracker.presentation

import androidx.fragment.app.viewModels
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentTasksListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksListFragment :
    BaseFragment<EmptyViewModel, FragmentTasksListBinding>(FragmentTasksListBinding::inflate) {
    override val viewModel: EmptyViewModel by viewModels()

    override fun init() {
        binding.fbtnAdd.navigate(R.id.action_tasksListFragment_to_addTaskFragment)
        binding.btnAdd.navigate(R.id.action_tasksListFragment_to_addTaskFragment)
    }


}