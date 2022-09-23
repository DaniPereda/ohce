package application

import domain.Day
import domain.Ohce


interface LanguagePrinterSecondaryAdapter {
    fun printHello(ohce:Ohce, momentOfDay:Day)

    fun printPalindrome(word:String)

    fun printNormalWord(word:String)

    fun printBye(name:String)
}