package application

import domain.Ohce
import domain.Status

internal class OhceServiceImpl(
    val reader: DataRetrieverPrimaryAdapter,
    val printer: LanguagePrinterSecondaryAdapter,
    val clock: Clock,
    val keysWords: KeywordsPort
) : OhceService {

    fun startOhceService() {
        var userName = reader.retrieveName()
        start(userName)

        while (newWordToAnalyze(reader.retrieveWord(), userName) != Status.EXIT) {
        }

    }

    override fun start(name: String) {
        val hourInt = clock.retrieveHour()
        var myOhce = Ohce()
        myOhce.sayHello(hourInt, name)
        printer.printHello(myOhce)
    }

    override fun newWordToAnalyze(word: String, userName:String):Status {
        var ohce: Ohce
        ohce = Ohce(word)
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