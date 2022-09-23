package domain

data class Ohce(var inputStr: String, var name: String, val ohceKeywords: Keywords) {
    var status = Status.NO_WORD

    fun analyzeNewWord() {

        //Waiting first word

        if (isStartingWord()) {
            name = startOhce(inputStr)
            status = Status.HELLO
        } else if (started()) {
            if (isExitWord()) {
                exitActions()
            } else if (isPalindromeWord()) {
                palindromeActions()
            } else {
                normalWordActions()
            }
        }

    }

    private fun started() = name != ""

    private fun exitActions() {
        status = Status.EXIT
    }

    private fun palindromeActions() {
        status = Status.PALINDROME
    }

    private fun normalWordActions() {
        inputStr = inputStr.reversed()
        status = Status.NORMAL_WORD
    }

    private fun isStartingWord() = ohceKeywords.isStart(inputStr) and (name =="")

    private fun isExitWord() = ohceKeywords.isExit(inputStr) and (name != "")

    private fun isPalindromeWord() = inputStr == inputStr.reversed()

    private fun startOhce(stringToClean: String): String {
        var splitList = stringToClean.split(" ").toMutableList()
        var splitSize = splitList.size
        var result = ""

        if (splitSize == 1)
            throw NoSuchFieldException("Name not provided")

        return isolateName()

    }

    private fun isolateName(): String {
        var splittedList = inputStr.split(" ").toMutableList()

        splittedList.removeAt(0)

        return splittedList.joinToString(separator = " ")
    }


}