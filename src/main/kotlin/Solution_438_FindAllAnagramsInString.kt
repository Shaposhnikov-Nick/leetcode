/**
 * 438 Find All Anagrams in a String
 *
 * Medium
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
fun main() {
    val s = "cbaebabacd"
    val p = "abc"
    findAnagrams(s, p)
}

/**
 * Подсчитываем количество совпадений букв в строке р
 * Используем скользящее окно размером р для прохода по всей строке s
 * Сначала считаем количество совпадений в первом окне от 0
 * В дальнейшем, чтобы не считать заново символы в каждом окне, удаляем из мапы левое значение и добавляем правое (типа префиксной суммы)
 * Если мапа окна соответствует мапе строки р, значит символы и их количество совпадают, добавлеям начальный индекс окна в result
 */
fun findAnagrams(s: String, p: String): List<Int> {
    if (p.length > s.length) return listOf()
    // Мапа для хранения частот символов строки р
    val pMap = mutableMapOf<Char, Int>()
    val result = mutableListOf<Int>()

    // Подсчитываем количество совпадений букв в строке р
    for (ch in p) {
        pMap.merge(ch, 1, Int::plus)
    }

    // Используем скользящее окно размером р для прохода по всей строке от 0
    val windowLength = p.length
    val windowMap = mutableMapOf<Char, Int>()

    // Сначала считаем количество совпадений в первом окне 0 до windowLength
    // В дальнейшем будем менять windowMap, двигая окно
    for (i in 0 until windowLength) {
        windowMap.merge(s[i], 1, Int::plus)
    }

    // Проходим по строке s двигая окно
    for (i in 0..s.length - windowLength) {
        // чтобы не считать заново символы в каждом окне, удаляем из мапы левое значение и добавляем правое
        if (i != 0) {
            // удаляем левое
            val value = windowMap.merge(s[i - 1], 1, Int::minus)
            if (value!! < 1) windowMap.remove(s[i - 1])
            // добавляем правое
            windowMap.merge(s[i + windowLength - 1], 1, Int::plus)
        }

        // Если мапа окна соответствует мапе строки р, добавлеям начальный индекс окна в result
        if (windowMap == pMap) result.add(i)
    }

    return result
}

/**
 * Медленное решение с подсчетом символов в каждом окне и сравнением с р
 */
fun findAnagrams2(s: String, p: String): List<Int> {
    val pMap = mutableMapOf<Char, Int>()
    val result = mutableListOf<Int>()

    for (ch in p) {
        pMap.merge(ch, 1, Int::plus)
    }

    val windowLength = p.length

    for (i in 0..s.length - windowLength) {
        val pMapCopy = HashMap<Char, Int>(pMap)

        for (j in i until i + p.length) {
            if (pMapCopy[s[j]] == null) break
            pMapCopy.merge(s[j], 1, Int::minus)
        }

        if (pMapCopy.values.all { it == 0 }) result.add(i)
    }

    return result
}
