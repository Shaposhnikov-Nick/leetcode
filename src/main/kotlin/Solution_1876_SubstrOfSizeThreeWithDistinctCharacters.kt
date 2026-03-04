/**
 * 1876 Substrings of Size Three with Distinct Characters
 *
 * Easy
 *
 * A string is good if there are no repeated characters.
 *
 * Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
 *
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "xyzzaz"
 * Output: 1
 * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 * The only good substring of length 3 is "xyz".
 * Example 2:
 *
 * Input: s = "aababcabc"
 * Output: 4
 * Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
 * The good substrings are "abc", "bca", "cab", and "abc".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s​​​​​​ consists of lowercase English letters.
 */
fun main() {
    val s = "aababcabc"
    countGoodSubstrings(s)
}

/**
 * Используем метод скользящего окна длиной 3
 * Получаем каждую подстроку длиной 3 и проверяем что в ней нет повторяющихся символов
 * Сдвигаем указатели вправо
 */
fun countGoodSubstrings(s: String): Int {
    if (s.length < 3) return 0

    var left = 0
    var right = 2
    var goodSubstrings = 0

    while (right < s.length) {
        // Получаем каждую подстроку длиной 3 и проверяем что в ней нет повторяющихся символов
        val subString = s.slice(left..right)
        val set = subString.toSet()
        if (set.size == subString.length) goodSubstrings++

        // Сдвигаем указатели вправо
        left++
        right++
    }

    return goodSubstrings
}