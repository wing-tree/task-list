package com.wing.tree.bruni.task.list.data.dao

import androidx.room.*
import com.wing.tree.bruni.task.list.data.model.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun get(): Flow<List<Task>>

    @Delete
    suspend fun delete(task: Task)

    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)
}