package com.wing.tree.bruni.task.list.data.datasource.task

import com.wing.tree.bruni.task.list.data.database.Database
import com.wing.tree.bruni.task.list.data.model.entity.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskDataSourceImpl @Inject constructor(database: Database) : TaskDataSource {
    private val taskDao = database.taskDao

    override fun get(): Flow<List<Task>> {
        return taskDao.get()
    }

    override suspend fun delete(task: Task) {
        taskDao.delete(task)
    }

    override suspend fun insert(task: Task) {
        taskDao.insert(task)
    }

    override suspend fun update(task: Task) {
        taskDao.update(task)
    }


}