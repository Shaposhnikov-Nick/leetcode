/**
 * 28 Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad",
 * Output: 0,
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto",
 * Output: -1,
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
fun main() {
    val haystack = "sadbutsad"
    val needle = "sad"
    val result = strStr(haystack, needle)
    println(result)
}

/**
 * Проверяем для каждого символа из haystack, что строка needle соответсвует ему посимвольно, начиная с этого символа,
 * при этом считаем длину совпадающих символов, и если она становится равна длине строки needle,
 * то возвращаем индекс этого символа из haystack.
 * Последние символы из haystack, меньше по длине чем длина needle проверять нет смысла.
 */
fun strStr(haystack: String, needle: String): Int {
    if (needle.length > haystack.length) return -1
    if (needle == haystack) return 0

    for (i in haystack.indices - needle.length) {
        var j = 0
        while (j < needle.length && haystack[i + j] == needle[j]) j++
        if (j == needle.length) return i
    }

    return -1
}

