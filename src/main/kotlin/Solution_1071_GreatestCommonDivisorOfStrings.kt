/**
 * 1071 Greatest Common Divisor of Strings
 *
 * Easy
 *
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
fun main() {
    val str1 = "ABABAB"
    val str2 = "ABAB"
    println(gcdOfStrings(str1, str2))
}

fun gcdOfStrings(str1: String, str2: String): String {
    var divisor = if (str1.length < str2.length) str1 else str2

    fun checkValid(str: String, divisor: String): Boolean {
        if (str.length % divisor.length != 0) return false
        var i = 0
        var j = divisor.length
        while (j <= str.length) {
            if (str.substring(i, j) != divisor) return false
            i += divisor.length
            j += divisor.length
        }
        return true
    }

    while (divisor.isNotEmpty()) {
        if (checkValid(str1, divisor) && checkValid(str2, divisor)) return divisor
        divisor = divisor.substring(0, divisor.length - 1)
    }

    return ""
}

/**
 * lower efficiency
 */
fun gcdOfStrings2(str1: String, str2: String): String {
    var divisor = if (str1.length < str2.length) str1 else str2

    while (divisor.isNotEmpty()) {
        val s1List = str1.chunked(divisor.length)
        val s2List = str2.chunked(divisor.length)
        if (s1List.all { it == divisor } && s2List.all { it == divisor }) return divisor
        divisor = divisor.substring(0, divisor.length - 1)
    }

    return ""
}
