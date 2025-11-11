/**
 * 387 First Unique Character in a String
 *
 * Easy
 * 
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 *
 * Output: 0
 *
 * Explanation:
 *
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 *
 * Example 2:
 *
 * Input: s = "loveleetcode"
 *
 * Output: 2
 *
 * Example 3:
 *
 * Input: s = "aabb"
 *
 * Output: -1
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
fun main() {
    val s = "leetcode"
    println(firstUniqChar(s))
}

/**
 * Подсчитываем количество каждого символа в строке
 * Затем по порядку проверяем каждый символ и возвращаем первый, у которого количество равно 1
 */
fun firstUniqChar(s: String): Int {
    val map = mutableMapOf<Char, Int>()

    // считаем количество каждого символа
    s.forEach {
        map.merge(it, 1) { oldValue, newValue -> oldValue + newValue }
    }

    // ищем первый символ в строке, количество которого равно 1
    s.forEachIndexed { index, ch ->
        if (map[ch] == 1) return index
    }

    // если уникального символа нет, возвращаем -1
    return -1
}