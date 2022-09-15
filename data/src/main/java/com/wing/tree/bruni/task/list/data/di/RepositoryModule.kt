package com.wing.tree.bruni.task.list.data.di

import com.wing.tree.bruni.task.list.data.repository.TaskRepositoryImpl
import com.wing.tree.bruni.task.list.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsTaskRepository(repository: TaskRepositoryImpl): TaskRepository
}