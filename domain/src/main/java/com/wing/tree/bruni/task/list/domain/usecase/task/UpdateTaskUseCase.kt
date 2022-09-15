package com.wing.tree.bruni.task.list.domain.usecase.task

import com.wing.tree.bruni.task.list.domain.model.Task
import com.wing.tree.bruni.task.list.domain.repository.TaskRepository
import com.wing.tree.bruni.task.list.domain.usecase.core.CoroutineUseCase
import com.wing.tree.bruni.task.list.domain.usecase.core.IOCoroutineDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository,
    @IOCoroutineDispatcher coroutineDispatcher: CoroutineDispatcher
) : CoroutineUseCase<Task, Unit>(coroutineDispatcher) {
    override suspend fun execute(parameter: Task) {
        repository.update(parameter)
    }
}