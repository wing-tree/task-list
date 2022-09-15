package com.wing.tree.bruni.task.list.domain.usecase.task

import com.wing.tree.bruni.task.list.domain.model.Task
import com.wing.tree.bruni.task.list.domain.repository.TaskRepository
import com.wing.tree.bruni.task.list.domain.usecase.core.IOCoroutineDispatcher
import com.wing.tree.bruni.task.list.domain.usecase.core.NoParameterFlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(
    private val repository: TaskRepository,
    @IOCoroutineDispatcher coroutineDispatcher: CoroutineDispatcher
) : NoParameterFlowUseCase<List<Task>>(coroutineDispatcher) {
    override fun execute(): Flow<List<Task>> {
        return repository.get()
    }
}