package infra.keywords

import application.KeywordsRepository
import domain.Keywords.Keys

class EnglishKeywordsRepository:KeywordsRepository {

    override fun setKeywords(): Map<Keys, String> {
        return (mapOf(setStartKeyword(), setStopKeyword()))
    }

    private fun setStopKeyword() = Pair(Keys.EXIT, "Stop!")

    private fun setStartKeyword() = Pair(Keys.START, "Ohce")
}