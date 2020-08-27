package com.example.activityresult.cap5.util

import java.util.regex.Pattern

fun String.removeAccents(): String {
    val replaces = arrayOf("a", "e", "i", "o", "u")
    val patterns = arrayOf(
        Pattern.compile("[áàãâ]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[éèê]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[íìî]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[óòõô]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[úùû]", Pattern.CASE_INSENSITIVE),
        Pattern.compile("[ç]", Pattern.CASE_INSENSITIVE)
    )

    var result = this
    for((index, value) in patterns.withIndex()){
        val matcher = value.matcher(result)
        result = matcher.replaceAll(replaces[index])
    }

    return result.toLowerCase()
}