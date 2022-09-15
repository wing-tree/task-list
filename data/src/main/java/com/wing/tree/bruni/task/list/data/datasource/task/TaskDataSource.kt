package com.wing.tree.bruni.task.list.data.datasource.task

import com.wing.tree.bruni.task.list.data.model.entity.Task
import kotlinx.coroutines.flow.Flow

interface TaskDataSource {
    fun get(): Flow<List<Task>>
    suspend fun delete(task: Task)
    suspend fun insert(task: Task)
    suspend fun update(task: Task)
}