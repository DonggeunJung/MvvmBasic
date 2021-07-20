package com.example.mvvmbasic.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Insert
    fun insert(quote: Quote)

    @Query("SELECT * FROM Quote")
    fun getAll(): List<Quote>
}