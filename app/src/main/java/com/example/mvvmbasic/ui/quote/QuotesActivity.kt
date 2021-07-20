package com.example.mvvmbasic.ui.quote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmbasic.R
import com.example.mvvmbasic.data.Quote
import com.example.mvvmbasic.util.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initUi()
    }

    private fun initUi() {
        val viewModel by viewModels<QuotesViewModel> { InjectorUtils.provideViewModelFactory(this) }
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            tvQuotes.text = stringBuilder.toString()
        })

        btnAddQuote.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuote(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }
    }
}
