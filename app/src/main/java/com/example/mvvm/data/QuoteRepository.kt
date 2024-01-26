package com.example.mvvm.data

import androidx.lifecycle.LiveData


class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes() as LiveData

    companion object {

        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }

            }
    }
}