package domain

data class Ohce(var word:String="", var name:String="", var status:Status = Status.NORMAL_WORD, var dayMoment:Day = Day.MORNING) {

    fun sayHello(hour:Int, myName:String){
        name = myName
        dayMoment = chooseMoment(hour)
        status = Status.HELLO
    }

    fun chooseMoment(hourInt:Int): Day
    {
        return if ((hourInt >= 20) or (hourInt < 6))
            Day.NIGHT
        else if (((hourInt >= 6) and (hourInt < 12)))
            Day.MORNING
        else
            Day.AFTERNOON
    }

    fun analizeNewWord(isStopKeyword:Boolean){
        if(isStopKeyword)
            status = Status.EXIT
        else if(isPalindrome())
            status = Status.PALINDROME
        else {
            word = word.reversed()
            status = Status.NORMAL_WORD
        }
    }

    private fun isPalindrome() = word == word.reversed()


}