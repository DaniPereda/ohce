package infra

import application.LanguagePrinterSecondaryAdapter
import domain.Day
import domain.Ohce

class SpanishConsolePrintSecondaryAdapter:LanguagePrinterSecondaryAdapter {
    override fun printHello(ohce:Ohce) {

        translateMorningAfternoonNight(ohce.dayMoment)
        println("${translateMorningAfternoonNight(ohce.dayMoment)} + ${ohce.name}")
    }

    private fun translateMorningAfternoonNight(mornigAfternoonNight: Day) =
        when (mornigAfternoonNight) {
            Day.MORNING -> "Buenos días"
            Day.AFTERNOON -> "Buenas tardes"
            Day.NIGHT -> "Buenas noches"
        }



    override fun printPalindrome(word: String) {
        println(word)
        println("!Bonita palabra!")
    }

    override fun printNormalWord(word: String) {
        println(word)
    }

    override fun printBye(name: String) {
        println("Adios $name")
    }
}