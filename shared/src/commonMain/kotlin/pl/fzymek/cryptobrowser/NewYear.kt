package pl.fzymek.cryptobrowser

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayIn(kotlinx.datetime.TimeZone.currentSystemDefault())
    val closestNewYearsEve = LocalDate(today.year +1, 1,1)
    return today.daysUntil(closestNewYearsEve)
}

fun daysPhrase(): String = "There are only ${daysUntilNewYear()} days left until New Year!"