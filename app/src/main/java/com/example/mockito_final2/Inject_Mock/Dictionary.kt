package com.example.mockito_final2.Inject_Mock

interface Dictionary {

    fun add(word: String, meaning: String)
    fun getMeaning(word: String): String
}