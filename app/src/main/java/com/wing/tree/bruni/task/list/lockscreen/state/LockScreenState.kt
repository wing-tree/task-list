package com.wing.tree.bruni.task.list.lockscreen.state

import com.wing.tree.bruni.task.list.domain.model.Task

sealed interface LockScreenState {
    object Loading: LockScreenState
    data class Content(val taskList: List<Task>) : LockScreenState
    data class Error(val throwable: Throwable) : LockScreenState
}