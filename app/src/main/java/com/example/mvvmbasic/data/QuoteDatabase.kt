package com.example.mvvmbasic.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun dao(): QuoteDao

    companion object {
        @Volatile private var instance: QuoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): QuoteDatabase? {
            if(instance == null) {
                synchronized(QuoteDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}