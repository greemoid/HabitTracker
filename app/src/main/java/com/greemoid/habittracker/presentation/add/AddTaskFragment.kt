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

        binding.btnAdvancedSettings.setOnClickListener {
            binding.linearLayout.visibility =
                if (binding.linearLayout.isVisible) View.GONE else View.VISIBLE
        }
        var icon = Icons.BOOK.toString()
        var color = Colors.BLUE.toString()
        binding.radioGroupWithIcons.setOnCheckedChangeListener { _, id ->
            when(id) {
                R.id.rb_book -> {
                    icon = Icons.BOOK.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_book)
                }
                R.id.rb_meditation -> {
                    icon = Icons.MEDITATION.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_meditation)
                }
                R.id.rb_money -> {
                    icon = Icons.MONEY.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_money)
                }
                R.id.rb_no_food -> {
                    icon = Icons.NO_FOOD.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_no_food)
                }
                R.id.rb_note -> {
                    icon = Icons.NOTE.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_note)
                }
                R.id.rb_palette -> {
                    icon = Icons.PALETTE.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_palette)
                }
                R.id.rb_laptop -> {
                    icon = Icons.LAPTOP.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_laptop)
                }
                R.id.rb_run -> {
                    icon = Icons.RUN.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_run)
                }
                R.id.rb_school -> {
                    icon = Icons.SCHOOL.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_school)
                }
                R.id.rb_sport -> {
                    icon = Icons.SPORT.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_sport)
                }
                else -> {
                    icon = Icons.BOOK.toString()
                    binding.ivIconOfTask.setImageResource(R.drawable.ic_book)
                }
            }
        }

        binding.radioGroupWithColors.setOnCheckedChangeListener { _, id ->
            when(id) {
                R.id.rb_blue -> {
                    color = Colors.BLUE.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_blue, resources.newTheme()))
                }
                R.id.rb_purple -> {
                    color = Colors.PURPLE.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.purple, resources.newTheme()))
                }
                R.id.rb_light_orange -> {
                    color = Colors.LIGHT_ORANGE.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_orange, resources.newTheme()))
                }
                R.id.rb_pelorous -> {
                    color = Colors.PELOROUS.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.pelorous, resources.newTheme()))
                }
                R.id.rb_orange -> {
                    color = Colors.ORANGE.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.orange, resources.newTheme()))
                }
                R.id.rb_sea -> {
                    color = Colors.SEA.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_sea, resources.newTheme()))
                }
                R.id.rb_red -> {
                    color = Colors.RED.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.red, resources.newTheme()))
                }
                R.id.rb_pink -> {
                    color = Colors.PINK.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.pink, resources.newTheme()))
                }
                else -> {
                    color = Colors.BLUE.toString()
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_blue, resources.newTheme()))
                }
            }
        }
        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()

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
                date = "false",
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
