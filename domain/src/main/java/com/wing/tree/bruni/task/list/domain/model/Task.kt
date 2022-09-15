package com.wing.tree.bruni.task.list.domain.model

abstract class Task {
    abstract val id: Long
    abstract val title: String
    abstract val description: String
}