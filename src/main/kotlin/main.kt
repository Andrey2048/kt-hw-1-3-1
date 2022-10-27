const val SECONDS_IN_MINUTE = 60
const val MINUTES_IN_HOUR = 60
const val HOURS_IN_DAY = 24

fun main() {
    println("Проверяем секунды")
    for (seconds in 0..SECONDS_IN_MINUTE + 1) {
        println("$seconds   " + agoToText(seconds))
    }

    println("Проверяем минуты")
    for (minutes in 0..MINUTES_IN_HOUR + 1) {
        println("$minutes   " + agoToText(minutes * SECONDS_IN_MINUTE))
    }

    println("Проверяем часы")
    for (hours in 0..HOURS_IN_DAY + 1) {
        println("$hours   " + agoToText(hours * MINUTES_IN_HOUR * SECONDS_IN_MINUTE))
    }

    println("Проверяем дни")
    for (days in 0..10) {
        println("$days   " + agoToText(days * HOURS_IN_DAY * MINUTES_IN_HOUR * SECONDS_IN_MINUTE))
    }

    println("Проверка контрольных точек")

    println(agoToText(SECONDS_IN_MINUTE))
    println(agoToText(SECONDS_IN_MINUTE + 1))
    println(agoToText(SECONDS_IN_MINUTE * MINUTES_IN_HOUR))
    println(agoToText(SECONDS_IN_MINUTE * MINUTES_IN_HOUR + 1))


}

fun agoToText(seconds: Int): String {
    return when {
        (seconds <= SECONDS_IN_MINUTE) -> "был(а) только что"
        (seconds <= (SECONDS_IN_MINUTE * MINUTES_IN_HOUR)) -> minutesAgo(seconds)
        (seconds <= (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY)) -> hoursAgo(seconds)
        (seconds <= (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY * 2)) -> "был(а) в сети вчера"
        (seconds <= (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY * 3)) -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesAgo(seconds: Int): String {
    val minutes = seconds / SECONDS_IN_MINUTE
    return when {
        ((minutes % 10 == 1) and (minutes % 100 != 11)) -> "был(а) $minutes минуту назад"
        ((minutes % 10 == 2) and (minutes % 100 != 12)) -> "был(а) $minutes минуты назад"
        ((minutes % 10 == 3) and (minutes % 100 != 13)) -> "был(а) $minutes минуты назад"
        ((minutes % 10 == 4) and (minutes % 100 != 14)) -> "был(а) $minutes минуты назад"
        else -> "был(а) $minutes минут назад"
    }
}

fun hoursAgo(seconds: Int): String {
    val hours = seconds / (SECONDS_IN_MINUTE * MINUTES_IN_HOUR)
    return when {
        ((hours % 10 == 1) and (hours % 100 != 11)) -> "был(а) в сети $hours час назад"
        ((hours % 10 == 2) and (hours % 100 != 12)) -> "был(а) в сети $hours часа назад"
        ((hours % 10 == 3) and (hours % 100 != 13)) -> "был(а) в сети $hours часа назад"
        ((hours % 10 == 4) and (hours % 100 != 14)) -> "был(а) в сети $hours часа назад"
        else -> "был(а) в сети $hours часов назад"
    }
}


