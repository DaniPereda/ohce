package domain

enum class Day {
    MORNING,
    AFTERNOON,
    NIGHT;

    companion object{

        fun chooseMoment(hourInt:Int): Day
        {
            return if (isNight(hourInt))
                Day.NIGHT
            else if (isMorning(hourInt))
                Day.MORNING
            else
                Day.AFTERNOON
        }

        private fun isMorning(hourInt: Int) = (hourInt >= 6) and (hourInt < 12)

        private fun isNight(hourInt: Int) = (hourInt >= 20) or (hourInt < 6)
    }
}

