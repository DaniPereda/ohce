package infra

import application.Clock
import java.time.LocalDateTime

class ClockImpl:Clock {
    override fun retrieveHour(): Int {
        return LocalDateTime.now().hour
    }
}