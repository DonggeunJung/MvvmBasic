package com.example.mvvmbasic.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository private constructor(private val quoteDao: QuoteDao) {
    private val quotes = MutableLiveData<List<Quote>>()

    fun addQuote(quote: Quote) {
        CoroutineScope(IO).launch {
            quoteDao.insert(quote)
            val list = quoteDao.getAll()

            withContext(Main) {
                quotes.value = list
            }
        }
    }

    fun getQuotes(): LiveData<List<Quote>> {
        if(quotes.value == null) {
            quotes.value = listOf()

            CoroutineScope(IO).launch {
                val list = quoteDao.getAll()

                withContext(Main) {
                    quotes.value = list
                }
            }
        }
        return quotes
    }

    companion object {
        @Volatile private var instance: Repository? = null
        fun getInstance(quoteDao: QuoteDao) =
            instance ?: synchronized(this) {
                instance ?: Repository(quoteDao).also { instance = it }
            }
    }
}
