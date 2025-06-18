import kotlin.math.max

/**
 * 1456 Maximum Number of Vowels in a Substring of Given Length
 *
 * Medium
 *
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */
fun main() {
    val s = "abciiidef"
    val k = 3
    println(maxVowels(s, k))
}

/**
 * 1 Инициализация окна: Сначала мы подсчитываем количество гласных в первой подстроке длины k.
 *
 * 2 Сдвиг окна: Затем мы сдвигаем окно на один символ вправо. При этом:
 *
 * Если символ, который выходит из окна (левый символ предыдущего окна), является гласной, уменьшаем текущий счетчик гласных.
 *
 * Если символ, который входит в окно (новый правый символ), является гласной, увеличиваем текущий счетчик гласных.
 *
 * 3 Обновление максимума: После каждого сдвига обновляем максимальное количество гласных, если текущее количество больше.
 *
 * 4 Оптимизация: Если в какой-то момент максимальное количество гласных становится равным k, можно сразу вернуть результат, так как большего количества быть не может.
 *
 * Это решение использует метод скользящего окна, что позволяет достичь временной сложности O(n), где n — длина строки s, и пространственной сложности O(1), так как мы используем только константное количество дополнительной памяти.
 *
 * На Java решение без использования Map
 */
fun maxVowels(s: String, k: Int): Int {
    var maxVowelsCount = 0
    var currentVowelsCount = 0
    val vowels = mapOf('a' to 'a', 'e' to 'e', 'i' to 'i', 'o' to 'o', 'u' to 'u')

    for (i in 0 until k) {
        if (vowels[s[i]] != null) currentVowelsCount++
    }
    maxVowelsCount = currentVowelsCount

    for (i in k until s.length) {
        if (vowels[s[i - k]] != null) currentVowelsCount--
        if (vowels[s[i]] != null) currentVowelsCount++
        if (maxVowelsCount == k) return maxVowelsCount
    }

    return maxVowelsCount
}