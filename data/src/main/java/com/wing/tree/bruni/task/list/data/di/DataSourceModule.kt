package com.wing.tree.bruni.task.list.data.di

import com.wing.tree.bruni.task.list.data.datasource.task.TaskDataSource
import com.wing.tree.bruni.task.list.data.datasource.task.TaskDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsTaskDataSource(dataSource: TaskDataSourceImpl): TaskDataSource
}