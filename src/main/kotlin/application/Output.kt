package application

import domain.Day
import domain.Ohce


interface Output {
    fun printHello(helloWord:String, name:String)

    fun printPalindrome(palindromePhrase:String, word:String)

    fun printNormal(word:String)

    fun printBye(byeWord:String, name:String)
}