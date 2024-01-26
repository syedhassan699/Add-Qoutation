package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.data.Quote
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.ui.QuotesViewModel
import com.example.mvvm.utilities.InjectorUtils

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuoteViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{
                quote ->  stringBuilder.append("$quote\n\n")
            }
            binding?.textViewQuotes?.text = stringBuilder.toString()
        })
        binding?.buttonAddQuote?.setOnClickListener{
            val quote = Quote(binding?.editTextQuote?.text.toString(),binding?.editTextAuthor?.text.toString())
            viewModel.addQuote(quote)
            binding?.editTextQuote?.setText("")
            binding?.editTextAuthor?.setText("")
        }
    }
}