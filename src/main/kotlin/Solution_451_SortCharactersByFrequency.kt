/**
 * 451 Sort Characters By Frequency
 *
 * Medium
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */
fun main() {
    val s = "loveleetcode"
    frequencySort(s)
}

/**
 * 1. Считаем количество совпадений символов в строке
 * 2. Преобразовываем строку в массив символов
 * 3. Сортируем с компаратором: сначала сравниваем количество символов. Если количество одинаковое, сортируем
 * чтобы символы шли по порядку
 * 4. Объединяем символы из массива в строку
 */
fun frequencySort(s: String): String {
    val map = mutableMapOf<Char, Int>()

    for (letter in s) {
        map.merge(letter, 1, Int::plus)
    }

    return s.toCharArray()
        .sortedWith { a, b ->
            val res = map[b]!! - map[a]!!   // сначала сравниваем количество символов
            if (res == 0) a - b else res    // если количество одинаковое, сортируем чтобы символы шли по порядку
        }
        .joinToString(separator = "")
}

fun frequencySort2(s: String): String {
    val freq = HashMap<Char, Int>()
    for (ch in s) {
        freq[ch] = (freq[ch] ?: 0) + 1
    }
    val sortedEntries = freq.entries.sortedByDescending { it.value }


    val sb = StringBuilder()
    for ((ch, rep) in sortedEntries) {
        repeat(rep) {
            sb.append(ch)
        }
    }
    return sb.toString()
}