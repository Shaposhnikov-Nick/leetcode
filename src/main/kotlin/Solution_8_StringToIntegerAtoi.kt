import java.math.BigInteger

/**
 * 8 String to Integer (atoi)
 *
 * Medium
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 *
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 *
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 *
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 *
 * Return the integer as the final result.
 */
fun main() {
//    val s = "   -042b3   "
    val s = "-91283472332"
    println(myAtoi(s))
}

fun myAtoi(s: String): Int {
    val trimmed = s.trim()
    if (trimmed.isEmpty()) return 0

    val sign = when {
        trimmed.startsWith('-') -> -1
        trimmed.startsWith('+') -> 1
        else -> 1
    }

    val startIndex = if (trimmed[0] == '-' || trimmed[0] == '+') 1 else 0

    val digits = buildString {
        for (i in startIndex until trimmed.length) {
            val ch = trimmed[i]
            if (ch.isDigit()) append(ch)
            else break
        }
    }

    if (digits.isEmpty()) return 0

    val numberStr = if (sign == -1) "-$digits" else digits
    val number = BigInteger(numberStr)

    return when {
        number > BigInteger.valueOf(Int.MAX_VALUE.toLong()) -> Int.MAX_VALUE
        number < BigInteger.valueOf(Int.MIN_VALUE.toLong()) -> Int.MIN_VALUE
        else -> number.toInt()
    }
}