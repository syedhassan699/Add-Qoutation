package com.example.mvvm.utilities

import android.annotation.SuppressLint
import com.example.mvvm.data.FakeDatabase
import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.ui.QuoteViewModelFactory

object InjectorUtils {

    @SuppressLint("SuspiciousIndentation")
    fun provideQuoteViewModelFactory(): QuoteViewModelFactory{
    val  quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}