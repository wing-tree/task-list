package com.wing.tree.bruni.task.list.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wing.tree.bruni.task.list.domain.model.Task

@Entity
class Task(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val title: String,
    override val description: String
) : Task()