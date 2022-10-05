package com.greemoid.habittracker.presentation

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentAddTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskFragment :
    BaseFragment<EmptyViewModel, FragmentAddTaskBinding>(FragmentAddTaskBinding::inflate) {
    override val viewModel: EmptyViewModel by viewModels()

    override fun init() {
        binding.btnExit.navigate(R.id.action_addTaskFragment_to_tasksListFragment)
        //todo if i open icons and without closing icons open colors i dont see anything
        binding.btnChooseColor.setOnClickListener {
            binding.linearWithCards.visibility =
                if (binding.linearWithCards.isVisible) View.GONE else View.VISIBLE
            binding.cardViewWithColors.visibility =
                if (binding.cardViewWithColors.isVisible) View.GONE else View.VISIBLE
            binding.cardViewWithIcons.visibility = View.GONE
        }
        binding.btnChooseIcon.setOnClickListener {
            binding.linearWithCards.visibility =
                if (binding.linearWithCards.isVisible) View.GONE else View.VISIBLE
            binding.cardViewWithIcons.visibility =
                if (binding.cardViewWithIcons.isVisible) View.GONE else View.VISIBLE
            binding.cardViewWithColors.visibility = View.GONE
        }
        binding.btnOpenRepeats.setOnClickListener {
            binding.linearWithCheckboxes.visibility =
                if (binding.linearWithCheckboxes.isVisible) View.GONE else View.VISIBLE
        }
    }


}
