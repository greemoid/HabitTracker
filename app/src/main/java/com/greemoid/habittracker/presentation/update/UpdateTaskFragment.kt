package com.greemoid.habittracker.presentation.update

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.habittracker.R
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.databinding.FragmentUpdateTaskBinding
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
            Icons.BOOK.toString() -> {
                binding.rbBook.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_book)
            }
            Icons.MEDITATION.toString() -> {
                binding.rbMeditation.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_meditation)
            }
            Icons.MONEY.toString() -> {
                binding.rbMoney.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_money)
            }
            Icons.NO_FOOD.toString() -> {
                binding.rbNoFood.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_no_food)
            }
            Icons.NOTE.toString() -> {
                binding.rbNote.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_note)
            }
            Icons.PALETTE.toString() -> {
                binding.rbPalette.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_palette)
            }
            Icons.LAPTOP.toString() -> {
                binding.rbLaptop.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_laptop)
            }
            Icons.RUN.toString() -> {
                binding.rbRun.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_run)
            }
            Icons.SCHOOL.toString() -> {
                binding.rbSchool.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_school)
            }
            Icons.SPORT.toString() -> {
                binding.rbSport.isChecked = true
                binding.ivIconOfTask.setImageResource(R.drawable.ic_sport)
            }
        }

        when(habitArgs.color) {
            Colors.BLUE.toString() -> {
                binding.rbBlue.isChecked = true
                binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_blue, resources.newTheme()))
            }
            Colors.PURPLE.toString() -> {
                binding.rbPurple.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.purple, resources.newTheme()))
            }
            Colors.LIGHT_ORANGE.toString() -> {
                binding.rbLightOrange.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_orange, resources.newTheme()))
            }
            Colors.PELOROUS.toString() -> {
                binding.rbPelorous.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.pelorous, resources.newTheme()))
            }
            Colors.ORANGE.toString() -> {
                binding.rbOrange.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.orange, resources.newTheme()))
            }
            Colors.SEA.toString() -> {
                binding.rbSea.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.light_sea, resources.newTheme()))
            }
            Colors.RED.toString() -> {
                binding.rbRed.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.red, resources.newTheme()))
            }
            Colors.PINK.toString() -> {
                binding.rbPink.isChecked = true
                    binding.colorOfTask.setCardBackgroundColor(resources.getColor(R.color.pink, resources.newTheme()))
            }
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

            val habit = HabitDbModel(
                id = habitArgs.id,
                title = title,
                icon = icon,
                color = color,
                date = habitArgs.date,
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