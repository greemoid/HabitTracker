package com.greemoid.habittracker.presentation.task

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentTaskBinding
import com.greemoid.habittracker.presentation.core.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment :
    BaseFragment<TaskViewModel, FragmentTaskBinding>(FragmentTaskBinding::inflate) {
    override val viewModel: TaskViewModel by viewModels()


    override fun init() {
        binding.btnGoBack.navigate(R.id.action_taskFragment_to_tasksListFragment)
        val args: TaskFragmentArgs by navArgs()
        binding.tvNameOfTheHabit.text = args.habit.title
        binding.btnDelete.setOnClickListener {
            viewModel.deleteHabit(args.habit)
            findNavController().navigate(R.id.action_taskFragment_to_tasksListFragment)
        }
    }


}