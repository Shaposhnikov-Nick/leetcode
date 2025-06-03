/**
 * 392 Is Subsequence
 *
 * Easy
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 */
fun main() {
    val s = "aaaaaa"
    val t = "bbaaaa"
    println(isSubsequence(s, t))
}

/**
 * Используется 2 указателя. Первый - каждый символ из s, и он ищется в t, если находится - счетчик совпавших символов увеличивается.
 * Поиск следующего символа из s начинается с последнего символа в t + 1 (второй указатель).
 * В конце число совпавших символов (counter) должно равняться длинне строки s.
 */
fun isSubsequence(s: String, t: String): Boolean {
    if (s.length > t.length) return false

    var lastIndex = 0
    var counter = 0

    for (sChar in s) {
        for (i in lastIndex..<t.length) {
            if (sChar == t[i]) {
                lastIndex = i + 1
                counter++
                break
            }
        }

    }
    return counter == s.length
}