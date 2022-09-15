package com.wing.tree.bruni.task.list.extension

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent

inline fun <reified T: Activity> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T: Service> Context.startForegroundService() {
    startForegroundService(Intent(this, T::class.java))
}