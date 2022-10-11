package com.greemoid.habittracker.presentation.add

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentAddTaskBinding
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.presentation.core.BaseFragment
import com.greemoid.habittracker.presentation.core.enums.Colors
import com.greemoid.habittracker.presentation.core.enums.Icons
import com.greemoid.habittracker.presentation.core.enums.PartOfDay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskFragment :
    BaseFragment<AddTaskViewModel, FragmentAddTaskBinding>(FragmentAddTaskBinding::inflate) {
    override val viewModel: AddTaskViewModel by viewModels()

    override fun init() {
        binding.btnExit.navigate(R.id.action_addTaskFragment_to_tasksListFragment)
        binding.btnChooseColor.setOnClickListener {
            binding.cardViewWithColors.visibility =
                if (binding.cardViewWithColors.isVisible) View.GONE else View.VISIBLE
            binding.cardViewWithIcons.visibility = View.GONE
        }
        binding.btnChooseIcon.setOnClickListener {
            binding.cardViewWithIcons.visibility =
                if (binding.cardViewWithIcons.isVisible) View.GONE else View.VISIBLE
            binding.cardViewWithColors.visibility = View.GONE
        }
        binding.btnOpenRepeats.setOnClickListener {
            binding.linearWithCheckboxes.visibility =
                if (binding.linearWithCheckboxes.isVisible) View.GONE else View.VISIBLE
        }

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()


            val icon = when (binding.radioGroupWithIcons.checkedRadioButtonId) {
                R.id.rb_book -> Icons.BOOK.toString()
                R.id.rb_meditation -> Icons.MEDITATION.toString()
                R.id.rb_money -> Icons.MONEY.toString()
                R.id.rb_no_food -> Icons.NO_FOOD.toString()
                R.id.rb_note -> Icons.NOTE.toString()
                R.id.rb_palette -> Icons.PALETTE.toString()
                R.id.rb_laptop -> Icons.LAPTOP.toString()
                R.id.rb_run -> Icons.RUN.toString()
                R.id.rb_school -> Icons.SCHOOL.toString()
                R.id.rb_sport -> Icons.SPORT.toString()
                else -> Icons.BOOK.toString()
            }

            val color = when (binding.radioGroupWithColors.checkedRadioButtonId) {
                R.id.rb_blue -> Colors.BLUE.toString()
                R.id.rb_green -> Colors.GREEN.toString()
                R.id.rb_light_orange -> Colors.LIGHT_ORANGE.toString()
                R.id.rb_pelorous -> Colors.PELOROUS.toString()
                R.id.rb_orange -> Colors.ORANGE.toString()
                R.id.rb_sea -> Colors.SEA.toString()
                R.id.rb_red -> Colors.RED.toString()
                R.id.rb_brown -> Colors.BROWN.toString()
                else -> Colors.BLUE.toString()
            }

            val partOfDay = when (binding.radioGroupWithDays.checkedRadioButtonId) {
                R.id.rb_doesnt_matter -> PartOfDay.DOESNTMATTER.toString()
                R.id.rb_morning -> PartOfDay.MORNING.toString()
                R.id.rb_day -> PartOfDay.DAY.toString()
                R.id.rb_evening -> PartOfDay.EVENING.toString()
                else -> PartOfDay.DOESNTMATTER.toString()
            }


            val doOnMonday = binding.cbMonday.isChecked
            val doOnTuesday = binding.cbTuesday.isChecked
            val doOnWednesday = binding.cbWednesday.isChecked
            val doOnThursday = binding.cbThursday.isChecked
            val doOnFriday = binding.cbFriday.isChecked
            val doOnSaturday = binding.cbSaturday.isChecked
            val doOnSunday = binding.cbSunday.isChecked


            val isCorrect = doOnMonday || doOnTuesday || doOnWednesday || doOnThursday
                    || doOnFriday || doOnSaturday || doOnSunday

            val habit = HabitModel(
                id = 0,
                title = title,
                icon = icon,
                color = color,
                isDone = false,
                totallyDays = 0,
                streakDays = 0,
                doOnMonday = doOnMonday,
                doOnTuesday = doOnTuesday,
                doOnWednesday = doOnWednesday,
                doOnThursday = doOnThursday,
                doOnFriday = doOnFriday,
                doOnSaturday = doOnSaturday,
                doOnSunday = doOnSunday,
                partOfDay = partOfDay
            )

            if (binding.etTitle.text.isNotEmpty()) {
                if (isCorrect) {
                    viewModel.addHabit(habit)
                    findNavController().navigate(R.id.action_addTaskFragment_to_tasksListFragment)
                } else {
                    Toast.makeText(requireContext(), "Check at least one day", Toast.LENGTH_SHORT)
                        .show()
                }

            } else {
                Toast.makeText(requireContext(), "Type a title for the habit", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }


}
