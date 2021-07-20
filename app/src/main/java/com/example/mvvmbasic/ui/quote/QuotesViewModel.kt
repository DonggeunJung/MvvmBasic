package com.example.mvvmbasic.ui.quote

import androidx.lifecycle.ViewModel
import com.example.mvvmbasic.data.Quote
import com.example.mvvmbasic.data.Repository

class QuotesViewModel(private val repository: Repository) : ViewModel() {

    fun getQuotes() = repository.getQuotes()

    fun addQuote(quote: Quote) = repository.addQuote(quote)
}
