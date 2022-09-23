package application

import domain.Keywords.Keys

interface KeywordsPort {
    fun setKeywords():Map<Keys, String>

}