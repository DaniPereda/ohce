package application

import domain.Day
import domain.Ohce


interface AdaptOutput {
    fun adaptHello(name:String, momentOfDay:Day)

    fun adaptPalindrome(word:String)

    fun adaptNormalWord(word:String)

    fun adaptBye(name:String)
}