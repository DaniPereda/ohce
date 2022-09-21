package application

import domain.Status

interface OhceService {
    fun start(name:String)
    fun newWordToAnalyze(word:String, userName:String):Status
}