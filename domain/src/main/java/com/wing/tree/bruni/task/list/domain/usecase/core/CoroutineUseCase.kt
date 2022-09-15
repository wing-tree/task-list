package com.wing.tree.bruni.task.list.domain.usecase.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class CoroutineUseCase<in P: Any, R: Any>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameter: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                Result.Success(execute(parameter))
            }
        } catch (t: Throwable) {
            Result.Failure(t)
        }
    }

    protected abstract suspend fun execute(parameter: P): R
}