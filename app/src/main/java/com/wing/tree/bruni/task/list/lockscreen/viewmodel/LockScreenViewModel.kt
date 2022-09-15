package com.wing.tree.bruni.task.list.lockscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wing.tree.bruni.task.list.domain.model.Task
import com.wing.tree.bruni.task.list.domain.usecase.core.Result
import com.wing.tree.bruni.task.list.domain.usecase.core.map
import com.wing.tree.bruni.task.list.domain.usecase.task.DeleteTaskUseCase
import com.wing.tree.bruni.task.list.domain.usecase.task.GetTaskListUseCase
import com.wing.tree.bruni.task.list.domain.usecase.task.InsertTaskUseCase
import com.wing.tree.bruni.task.list.domain.usecase.task.UpdateTaskUseCase
import com.wing.tree.bruni.task.list.lockscreen.state.LockScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LockScreenViewModel @Inject constructor(
    getTaskListUseCase: GetTaskListUseCase,
    deleteTaskUseCase: DeleteTaskUseCase,
    updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {
//    val state: StateFlow<LockScreenState> = getTaskListUseCase().map { result ->
//        when(result) {
//            Result.Loading -> LockScreenState.Loading
//            is Result.Success -> LockScreenState.Content(result.data)
//            is Result.Failure -> LockScreenState.Error(result.throwable)
//        }
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(),
//        initialValue = LockScreenState.Loading
//    )
}