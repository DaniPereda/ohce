package application

import domain.Ohce
import domain.Status

internal class OhceServiceImpl(
    val reader: DataRetrieverPrimaryAdapter,
    val printer: LanguagePrinterSecondaryAdapter,
    val clock: Clock,
    val keysWords: KeywordsPort
) : OhceService {

    var userName:String = ""

    fun startOhceService() {
        userName = analyzeFirstWord()

        while (analyzeNewWord() != Status.EXIT) {
        }

    }

    override fun analyzeFirstWord():String {
        val userName = reader.retrieveName()
        val hourInt = clock.retrieveHour()
        var myOhce = Ohce()
        myOhce.sayHello(hourInt, userName)
        printer.printHello(myOhce)
        return userName
    }

    override fun analyzeNewWord():Status {
        var ohce: Ohce
        ohce = Ohce(word = reader.retrieveWord())
        ohce.analizeNewWord(keysWords.isStopKeyword(ohce.word))

        when (ohce.status) {
            Status.NORMAL_WORD -> printer.printNormalWord(ohce.word)
            Status.PALINDROME -> printer.printPalindrome(ohce.word)
            Status.EXIT -> {
                printer.printBye(userName)
            }
            Status.HELLO -> {}
        }

        return ohce.status
    }


}