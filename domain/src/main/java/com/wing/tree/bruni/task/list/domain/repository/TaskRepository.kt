package com.wing.tree.bruni.task.list.domain.repository

import com.wing.tree.bruni.task.list.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun get(): Flow<List<Task>>
    suspend fun delete(task: Task)
    suspend fun insert(task: Task)
    suspend fun update(task: Task)
}