package infra.keywords

import application.KeywordsPort
import domain.Keywords.Keys

class EnglishKeywordsPort:KeywordsPort {

    override fun setKeywords(): Map<Keys, String> {
        return (mapOf(setStartKeyword(), setStopKeyword()))
    }

    private fun setStopKeyword() = Pair(Keys.EXIT, "Stop!")

    private fun setStartKeyword() = Pair(Keys.START, "Ohce")
}