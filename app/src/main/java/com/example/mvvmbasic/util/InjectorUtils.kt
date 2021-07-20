package com.example.mvvmbasic.util

import android.content.Context
import com.example.mvvmbasic.data.QuoteDatabase
import com.example.mvvmbasic.data.Repository
import com.example.mvvmbasic.ViewModelFactory

object InjectorUtils {

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val repository = Repository.getInstance(QuoteDatabase.getInstance(context)!!.dao())
        return ViewModelFactory(repository)
    }
}
