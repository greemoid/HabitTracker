package com.greemoid.habittracker.presentation.date

import java.text.SimpleDateFormat
import java.util.*

interface CurrentDate {
    fun getCurrentDate(): String
    fun getCurrentFullDate(): String

    class Base() : CurrentDate {
        override fun getCurrentDate(): String {
            val date = getCurrentDateTime().toString("dd")
            val day = getCurrentDay().substring(0, 2)
            return "$date $day"
        }

        override fun getCurrentFullDate(): String {
            return getCurrentDateTime().toString("d.M.yyyy")
        }

        private fun getCurrentDateTime(): Date {
            return Calendar.getInstance().time
        }

        private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
            val formatter = SimpleDateFormat(format, locale)
            return formatter.format(this)
        }

        private fun getCurrentDay(): String {
            val calendar = Calendar.getInstance()
            val date = calendar.time
            return SimpleDateFormat("EEEE", Locale.getDefault()).format(date.time)
        }
    }
}