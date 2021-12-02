package com.example.mockito_final2.Inject_Mock

class WordDictionary : Dictionary {


    private val wordsMap: MutableMap<String, String>
    override fun add(word: String, meaning: String) {
        wordsMap[word] = meaning
    }

    override fun getMeaning(word: String): String {
        return wordsMap[word]!!
    }

    init {
        wordsMap = HashMap()
    }
}