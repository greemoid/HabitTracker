package com.greemoid.habittracker.presentation.notifications


import android.app.PendingIntent
import android.app.PendingIntent.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.greemoid.habittracker.R
import com.greemoid.habittracker.data.cache.HabitDbModel
import com.greemoid.habittracker.presentation.core.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val habit = intent?.getSerializableExtra("habit") as? HabitDbModel
        val tapResultIntent = Intent(context, MainActivity::class.java)
        tapResultIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent: PendingIntent =
            getActivity(context, 0, tapResultIntent, FLAG_UPDATE_CURRENT or FLAG_IMMUTABLE)

        val notification = context?.let {
            NotificationCompat.Builder(it, "habit_tracker")
                .setContentTitle("Task Reminder")
                .setContentText(habit?.title)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
                .build()
        }
        val notificationManager = context?.let { NotificationManagerCompat.from(it) }
        notification?.let { habit?.let { it1 -> notificationManager?.notify(it1.id, it) } }
        Log.d("NOTIFICATION", "poshlo")
    }
}
