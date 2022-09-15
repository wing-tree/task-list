package com.wing.tree.bruni.task.list.writetask.viewmodel

import androidx.lifecycle.ViewModel
import com.wing.tree.bruni.task.list.domain.usecase.task.InsertTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WriteTaskViewModel @Inject constructor(
    insertTaskUseCase: InsertTaskUseCase
): ViewModel() {
}