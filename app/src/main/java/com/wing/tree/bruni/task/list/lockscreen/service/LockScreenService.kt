package com.wing.tree.bruni.task.list.lockscreen.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.wing.tree.bruni.task.list.main.MainActivity
import com.wing.tree.bruni.task.list.R
import com.wing.tree.bruni.task.list.lockscreen.receiver.LockScreenBroadcastReceiver
import com.wing.tree.bruni.task.list.constant.ONE
import com.wing.tree.bruni.task.list.constant.ZERO

class LockScreenService : Service() {
    private val lockScreenBroadcastReceiver = LockScreenBroadcastReceiver()
    private val channelId = packageName
    private val notificationId = ONE

    private val notificationChannel by lazy {
        val id = channelId
        val name = getString(R.string.channel_name)
        val importance = NotificationManager.IMPORTANCE_MIN
        val notificationChannel = NotificationChannel(id, name, importance)

        notificationChannel.apply {
            setShowBadge(false)
        }
    }
    private val notification by lazy {
        val notificationManager = getSystemService(NotificationManager::class.java)

        notificationManager.createNotificationChannel(notificationChannel)

        val pendingIntent = PendingIntent.getActivity(
            this,
            ZERO,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val icon = R.drawable.ic_round_task_24
        val argb = ContextCompat.getColor(this, R.color.notification)
        val title = getString(R.string.notification_title)
        val text = getString(R.string.notification_text)

        NotificationCompat.Builder(this, channelId)
            .setSmallIcon(icon)
            .setColor(argb)
            .setContentTitle(title)
            .setContentText(text)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_MIN)
            .setShowWhen(false)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        startForeground()

        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_USER_PRESENT)
        }

        registerReceiver(lockScreenBroadcastReceiver, intentFilter)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
       return START_STICKY
    }

    override fun onDestroy() {
        unregisterReceiver(lockScreenBroadcastReceiver)

        super.onDestroy()
    }

    private fun startForeground() {
        val id = notificationId

        startForeground(id, notification)
    }
}