package application

import domain.Day
import domain.Keywords
import domain.Ohce
import domain.Status

internal class OhceServiceImpl(
    private val reader: DataRetriever,
    private val printer: AdaptOutput,
    private val clock: Clock,
    private val keysWordsPort: KeywordsRepository
) : OhceService {

    private val keyWords = Keywords(keysWordsPort.setKeywords())
    var userName:String = ""


    fun start(){
        while(analyzeNewWord() != Status.EXIT){

        }
    }

    override fun analyzeNewWord():Status {
        val ohce = Ohce(inputStr = reader.retrieveInputStr(), userName, keyWords)

        ohce.analyzeNewWord()

        when (ohce.status) {
            Status.HELLO -> {
                userName = ohce.name
                printer.adaptHello(userName, Day.chooseMoment(clock.retrieveHour()))
            }
            Status.NORMAL_WORD -> printer.adaptNormalWord(ohce.inputStr)
            Status.PALINDROME -> printer.adaptPalindrome(ohce.inputStr)
            Status.EXIT -> {
                printer.adaptBye(userName)
                userName = ""
            }
            else -> { }

        }

        return ohce.status
    }


}