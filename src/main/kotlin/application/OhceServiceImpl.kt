package application

import domain.Day
import domain.Keywords
import domain.Ohce
import domain.Status

internal class OhceServiceImpl(
    private val reader: DataRetrieverPrimaryAdapter,
    private val printer: LanguagePrinterSecondaryAdapter,
    private val clock: Clock,
    private val keysWordsPort: KeywordsPort
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
                printer.printHello(ohce, Day.chooseMoment(clock.retrieveHour()))
            }
            Status.NORMAL_WORD -> printer.printNormalWord(ohce.inputStr)
            Status.PALINDROME -> printer.printPalindrome(ohce.inputStr)
            Status.EXIT -> {
                printer.printBye(userName)
                userName = ""
            }
            else -> { }

        }

        return ohce.status
    }


}