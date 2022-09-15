package com.wing.tree.bruni.task.list.lockscreen.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.wing.tree.bruni.task.list.lockscreen.view.LockScreenActivity

class LockScreenBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_SCREEN_OFF -> context.startActivity()
            Intent.ACTION_USER_PRESENT -> context.startActivity()
        }
    }

    private fun Context.startActivity() {
        Intent(this, LockScreenActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}