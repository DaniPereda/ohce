package application

import domain.Keywords.Keys

interface KeywordsRepository {
    fun setKeywords():Map<Keys, String>

}