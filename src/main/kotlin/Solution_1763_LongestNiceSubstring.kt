/**
 * 1763. Longest Nice Substring
 *
 * Easy
 *
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 *
 * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "YazaAay"
 * Output: "aAa"
 * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
 * "aAa" is the longest nice substring.
 * Example 2:
 *
 * Input: s = "Bb"
 * Output: "Bb"
 * Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
 * Example 3:
 *
 * Input: s = "c"
 * Output: ""
 * Explanation: There are no nice substrings.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists of uppercase and lowercase English letters.
 */
fun main() {
    val s = "YazaAay"
    longestNiceSubstring(s)
}

/**
 * Идём от больших длин к меньшим - так мы найдём самую длинную подстроку быстрее и можем сразу вернуть результат.
 * Перебираем все возможные длины подстрок (от длины строки до 2).
 * Для каждой длины подстроки вначале считаем первое окно, затем сразу его проверяем.
 * Далее двигаем окно, удаляем левый элемент, добавляем правый и проверяем получившуюся подстроку.
 */
fun longestNiceSubstring(s: String): String {
    if (s.length < 2) return ""
    var longestSubstr = ""

    fun isNiceSubstring(map: MutableMap<Char, Int>): Boolean {
        for (ch in map.keys) {
            if (ch.isUpperCase() && !map.containsKey(ch.lowercaseChar())) return false
            if (ch.isLowerCase() && !map.containsKey(ch.uppercaseChar())) return false
        }

        return true
    }

    // Идём от больших длин к меньшим для оптимальности
    for (substrLength in s.length downTo 2) {
        val map = mutableMapOf<Char, Int>()

        for (i in 0 until substrLength) {
            map.merge(s[i], 1, Int::plus)
        }

        // Проверка первого окна
        if (isNiceSubstring(map)) {
            longestSubstr = s.substring(0, substrLength)
            return longestSubstr
        }

        // Сдвигаем окно
        for (left in 1 until s.length - substrLength + 1) {
            val right = left + substrLength - 1

            // Удаляем левый символ
            val charToRemove = s[left - 1]
            map[charToRemove] = map.getOrDefault(charToRemove, 0) - 1
            if (map[charToRemove] == 0) map.remove(charToRemove)

            // Добавляем правый символ
            val charToAdd = s[right]
            map[charToAdd] = map.getOrDefault(charToAdd, 0) + 1

            // Проверяем текущее окно
            if (isNiceSubstring(map)) {
                return s.substring(left, right + 1)
            }
        }

    }


    return longestSubstr
}