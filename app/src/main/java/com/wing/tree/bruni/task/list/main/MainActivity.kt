package com.wing.tree.bruni.task.list.main

import android.app.ActivityOptions
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.wing.tree.bruni.task.list.R
import com.wing.tree.bruni.task.list.constant.EXTRA_CAN_DRAW_OVERLAYS
import com.wing.tree.bruni.task.list.constant.SCHEME_PACKAGE
import com.wing.tree.bruni.task.list.extension.milliseconds
import com.wing.tree.bruni.task.list.extension.startForegroundService
import com.wing.tree.bruni.task.list.lockscreen.service.LockScreenService

class MainActivity : AppCompatActivity() {
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        intent?.let {
            val canDrawOverlays = it.getBooleanExtra(EXTRA_CAN_DRAW_OVERLAYS, false)

            if (canDrawOverlays) {
                startForegroundService<LockScreenService>()
            }
        }
    }

    private fun checkPermission() {
        if (Settings.canDrawOverlays(this))
            startForegroundService<LockScreenService>()
        else {
            MaterialAlertDialogBuilder(this)
                .setIcon(R.drawable.ic_round_task_24)
                .setTitle("")
                .setMessage("")
                .setNegativeButton(R.string.deny) { _, _ ->

                }
                .setPositiveButton(R.string.allow) { _, _ ->
                    val scheme = SCHEME_PACKAGE
                    val uri = Uri.fromParts(scheme, packageName, null)
                    val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri).apply {
                        flags = Intent.FLAG_ACTIVITY_NO_HISTORY
                    }

                    val delayMillis = 600.milliseconds

                    startActivity(intent)
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)

                    handler = Handler(mainLooper)

                    handler?.postDelayed(
                        object : Runnable {
                            override fun run() {
                                if (Settings.canDrawOverlays(this@MainActivity)) {
                                    with(Intent(this@MainActivity, MainActivity::class.java)) {
                                        putExtra(EXTRA_CAN_DRAW_OVERLAYS, Settings.canDrawOverlays(this@MainActivity))

                                        val customAnimation = ActivityOptions.makeCustomAnimation(
                                            this@MainActivity,
                                            android.R.anim.slide_in_left,
                                            android.R.anim.slide_out_right
                                        )

                                        startActivity(this, customAnimation.toBundle())
                                    }

                                    handler = null

                                    return
                                }

                                handler?.postDelayed(this, delayMillis)
                            }
                        },
                        delayMillis
                    )
                }
                .show()
        }
    }
}