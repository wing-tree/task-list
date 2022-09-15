package com.wing.tree.bruni.task.list.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wing.tree.bruni.task.list.data.dao.TaskDao
import com.wing.tree.bruni.task.list.data.model.entity.Task

@androidx.room.Database(
    entities = [Task::class],
    exportSchema = false,
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val taskDao: TaskDao

    companion object {
        private const val PACKAGE_NAME = "com.wing.tree.bruni.task.list.data.database"
        private const val CLASS_NAME = "Database"
        private const val NAME = "$PACKAGE_NAME.$CLASS_NAME"
        private const val VERSION = "1.0.0"

        @Volatile
        private var INSTANCE: Database? = null

        fun getInstance(context: Context): Database {
            synchronized(this) {
                return INSTANCE ?: run {
                    Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        "$NAME.$VERSION"
                    )
                        .build()
                        .also {
                            INSTANCE = it
                        }
                }
            }
        }
    }
}