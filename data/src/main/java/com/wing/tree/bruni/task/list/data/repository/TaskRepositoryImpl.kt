package com.wing.tree.bruni.task.list.data.repository

import com.wing.tree.bruni.task.list.data.datasource.task.TaskDataSource
import com.wing.tree.bruni.task.list.domain.model.Task
import com.wing.tree.bruni.task.list.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(dataSource: TaskDataSource) : TaskRepository {
    override fun get(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun insert(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun update(task: Task) {
        TODO("Not yet implemented")
    }
}