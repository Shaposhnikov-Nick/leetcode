/**
 * 567 Permutation in String
 *
 * Medium
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
fun main() {
    val s1 = "ab"
    val s2 = "eidbaooo"
    checkInclusion(s1, s2)
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false
    if (s1 == s2) return true

    // Создаем Map для хранения частот символов в строке s1 и в каждой подстроке s2
    val s1Map = mutableMapOf<Char, Int>()
    val s2Map = mutableMapOf<Char, Int>()
    val windowLength = s1.length

    // Заполняем мапы
    for (i in s1) {
        s1Map.merge(i, 1, Int::plus)
    }

    for (i in 0 until windowLength) {
        s2Map.merge(s2[i], 1, Int::plus)
    }

    if (s1Map == s2Map) return true

    // Проходим по s2 начиная с 1 индекса и  удаляем из скользящего окна предыдущий символ
    // добавляем следующий, чтобы не пересчитывать полностью s2Map при каждом передвижении окна
    // Если символы и их колиество совпали, возвращаем true
    for (i in 1..s2.length - windowLength) {
        // удаляем из скользящего окна предыдущий символ
        val count = s2Map.merge(s2[i - 1], 1, Int::minus)
        if (count!! < 1) s2Map.remove(s2[i - 1])
        // добавляем следующий символ
        s2Map.merge(s2[i + windowLength - 1], 1, Int::plus)
        // Если символы и их количество совпали, возвращаем true
        if (s1Map == s2Map) return true
    }

    return false
}
