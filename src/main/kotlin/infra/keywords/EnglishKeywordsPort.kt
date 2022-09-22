package infra.keywords

import application.KeywordsPort

class EnglishKeywordsPort:KeywordsPort {

    override fun isStopKeyword(word:String): Boolean {
        return (word == "Stop!")
    }
}