package com.greemoid.habittracker.presentation

import android.util.Log
import androidx.fragment.app.viewModels
import com.greemoid.habittracker.databinding.FragmentAddTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskFragment :
    BaseFragment<EmptyViewModel, FragmentAddTaskBinding>(FragmentAddTaskBinding::inflate) {
    override val viewModel: EmptyViewModel by viewModels()

    override fun init() {
        binding.rbDay.setOnCheckedChangeListener { _, b ->
            Log.d("RADIO", b.toString())
        }
    }


}
