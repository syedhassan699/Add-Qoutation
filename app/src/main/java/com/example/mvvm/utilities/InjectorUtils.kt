package com.example.mvvm.utilities

import com.example.mvvm.data.FakeDatabase
import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.ui.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuoteViewModelFactory(): QuoteViewModelFactory{
    val  quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}