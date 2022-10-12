package com.greemoid.habittracker.presentation.update

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.habittracker.R
import com.greemoid.habittracker.databinding.FragmentUpdateTaskBinding
import com.greemoid.habittracker.domain.HabitModel
import com.greemoid.habittracker.presentation.core.BaseFragment
import com.greemoid.habittracker.presentation.core.enums.Colors
import com.greemoid.habittracker.presentation.core.enums.Icons
import com.greemoid.habittracker.presentation.core.enums.PartOfDay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateTaskFragment :
    BaseFragment<UpdateViewModel, FragmentUpdateTaskBinding>(FragmentUpdateTaskBinding::inflate) {
    override val viewModel: UpdateViewModel by viewModels()

    override fun init() {
        val args: UpdateTaskFragmentArgs by navArgs()
        val habitArgs = args.habit
        binding.etTitle.setText(habitArgs.title)

        binding.cbSunday.isChecked = habitArgs.doOnSunday
        binding.cbMonday.isChecked = habitArgs.doOnMonday
        binding.cbTuesday.isChecked = habitArgs.doOnTuesday
        binding.cbWednesday.isChecked = habitArgs.doOnWednesday
        binding.cbThursday.isChecked = habitArgs.doOnThursday
        binding.cbFriday.isChecked = habitArgs.doOnFriday
        binding.cbSaturday.isChecked = habitArgs.doOnSaturday


        when(habitArgs.icon) {
            Icons.BOOK.toString() -> binding.rbBook.isChecked = true
            Icons.MEDITATION.toString() -> binding.rbMeditation.isChecked = true
            Icons.MONEY.toString() -> binding.rbMoney.isChecked = true
            Icons.NO_FOOD.toString() -> binding.rbNoFood.isChecked = true
            Icons.NOTE.toString() -> binding.rbNote.isChecked = true
            Icons.PALETTE.toString() -> binding.rbPalette.isChecked = true
            Icons.LAPTOP.toString() -> binding.rbLaptop.isChecked = true
            Icons.RUN.toString() -> binding.rbRun.isChecked = true
            Icons.SCHOOL.toString() -> binding.rbSchool.isChecked = true
            Icons.SPORT.toString() -> binding.rbSport.isChecked = true
        }

        when(habitArgs.color) {
            Colors.BLUE.toString() -> binding.rbBlue.isChecked = true
            Colors.GREEN.toString() -> binding.rbGreen.isChecked = true
            Colors.LIGHT_ORANGE.toString() -> binding.rbLightOrange.isChecked = true
            Colors.PELOROUS.toString() -> binding.rbPelorous.isChecked = true
            Colors.ORANGE.toString() -> binding.rbOrange.isChecked = true
            Colors.SEA.toString() -> binding.rbSea.isChecked = true
            Colors.RED.toString() -> binding.rbRed.isChecked = true
            Colors.BROWN.toString() -> binding.rbBrown.isChecked = true
        }

        when(habitArgs.partOfDay) {
            PartOfDay.DOESNTMATTER.toString() -> binding.rbDoesntMatter.isChecked = true
            PartOfDay.MORNING.toString() -> binding.rbMorning.isChecked = true
            PartOfDay.DAY.toString() -> binding.rbDay.isChecked = true
            PartOfDay.EVENING.toString() -> binding.rbEvening.isChecked = true
        }

        binding.btnExit.navigate(R.id.action_updateTaskFragment_to_tasksListFragment)

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
                id = habitArgs.id,
                title = title,
                icon = icon,
                color = color,
                isDone = habitArgs.isDone,
                totallyDays = habitArgs.totallyDays,
                streakDays = habitArgs.streakDays,
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
                    viewModel.update(habit)
                    findNavController().navigate(R.id.action_updateTaskFragment_to_tasksListFragment)
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