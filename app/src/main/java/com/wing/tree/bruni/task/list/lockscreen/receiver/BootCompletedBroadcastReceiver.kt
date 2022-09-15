package com.wing.tree.bruni.task.list.lockscreen.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.wing.tree.bruni.task.list.extension.startForegroundService
import com.wing.tree.bruni.task.list.lockscreen.service.LockScreenService

class BootCompletedBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_BOOT_COMPLETED -> context?.startForegroundService<LockScreenService>()
        }
    }
}