package com.kmpstudy.core.util.extension

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.YearMonth
import kotlinx.datetime.number


// DayOfWeek 扩展函数
fun DayOfWeek.toLocalizedString(locale: String = "zh"): String {
    return when (locale) {
        "zh" -> when (this) {
            DayOfWeek.MONDAY -> "一"
            DayOfWeek.TUESDAY -> "二"
            DayOfWeek.WEDNESDAY -> "三"
            DayOfWeek.THURSDAY -> "四"
            DayOfWeek.FRIDAY -> "五"
            DayOfWeek.SATURDAY -> "六"
            DayOfWeek.SUNDAY -> "日"
        }

        "en" -> when (this) {
            DayOfWeek.MONDAY -> "Mon"
            DayOfWeek.TUESDAY -> "Tue"
            DayOfWeek.WEDNESDAY -> "Wed"
            DayOfWeek.THURSDAY -> "Thu"
            DayOfWeek.FRIDAY -> "Fri"
            DayOfWeek.SATURDAY -> "Sat"
            DayOfWeek.SUNDAY -> "Sun"
        }

        else -> this.name
    }
}

// YearMonth 扩展函数
fun YearMonth.toLocalizedString(locale: String = "zh"): String {
    return when (locale) {
        "zh" -> "${this.year}年${this.month.number}月"
        "en" -> "${this.month.number}/${this.year}"
        else -> "${this.month.number}/${this.year}"
    }
}