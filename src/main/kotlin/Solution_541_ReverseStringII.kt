import kotlin.math.min

/**
 * 541 Reverse String II
 *
 * Easy
 *
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 */
fun main() {
    val s = "abcdefg"
    val k = 2
    reverseStr(s, k)
}

/**
 * Используем 2 указателя для подстроки длиной k.
 * Каждую вторую подстроку длиной k поочередно, начиная с первой, разворачиваем.
 * Подстроки между ними оставляем как есть.
 */
fun reverseStr(s: String, k: Int): String {
    // Два указателя для подстроки
    var left = 0
    var right = k - 1
    // Флаг, что нужно развернуть подстроку
    var reverse = true
    // StringBuilder для собирания новой строки
    val sb = StringBuilder()

    // Если длина строки меньше длины подстроки k, то просто сразу разворачиваем ее
    if (s.length < k) {
        for (i in s.indices.reversed()) {
            sb.append(s[i])
        }
        return sb.toString()
    }

    // Берем каждую подстроку  длиной k
    while (right <= s.length + k) {
        // Если установлен флаг для реверса (для первой подстроки и потом через одну)
        if (reverse) {
            // Добавляем символы из подстроки в обратном порядке (разворачиваем подстроку
            // При этом проверяем, чтобы в конце строки указатель не вышел за пределы самоц строки
            // если последняя подстрока длиной меньше k
            var i = min(s.length - 1, right)
            while (i >= left) {
                sb.append(s[i])
                i--
            }
            // Устанавливаем флаг, что следующую подстроку не нужно разворачивать
            reverse = false
        } else {
            // Если подстроку не нужно разворачивать
            // Просто добавляем ее символ
            var i = left
            while (i < s.length && i <= right) {
                sb.append(s[i])
                i++
            }
            // Устанавливаем флаг, что следующую подстроку нужно развернуть
            reverse = true
        }
        // Сдвигаем указатели на следующую подстроку
        left = right + 1
        right += k
    }

    return sb.toString()
}