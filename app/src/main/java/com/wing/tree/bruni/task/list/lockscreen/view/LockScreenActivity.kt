package com.wing.tree.bruni.task.list.lockscreen.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.wing.tree.bruni.task.list.databinding.ActivityLockScreenBinding
import com.wing.tree.bruni.task.list.extension.startActivity
import com.wing.tree.bruni.task.list.lockscreen.viewmodel.LockScreenViewModel
import com.wing.tree.bruni.task.list.writetask.view.WriteTaskActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LockScreenActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityLockScreenBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<LockScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        bind()
        collect()
    }

    private fun bind() {
        with(viewBinding) {
            imageButtonWriteTask.setOnClickListener {
                startActivity<WriteTaskActivity>()
            }
        }
    }

    private fun collect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
//                viewModel.state.collect {
//
//                }
            }
        }
    }
}