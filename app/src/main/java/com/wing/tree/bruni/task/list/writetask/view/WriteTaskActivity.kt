package com.wing.tree.bruni.task.list.writetask.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wing.tree.bruni.task.list.writetask.viewmodel.WriteTaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriteTaskActivity : AppCompatActivity() {
    private val viewModel by viewModels<WriteTaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}