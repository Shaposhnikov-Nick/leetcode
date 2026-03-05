import kotlin.math.max

/**
 * 3090 Maximum Length Substring With Two Occurrences
 *
 * Easy
 *
 * Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 *
 *
 * Example 1:
 *
 * Input: s = "bcbbbcba"
 *
 * Output: 4
 *
 * Explanation:
 *
 * The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
 * Example 2:
 *
 * Input: s = "aaaa"
 *
 * Output: 2
 *
 * Explanation:
 *
 * The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 100
 * s consists only of lowercase English letters.
 */
fun main() {
    val s = "bcbbbcba"
    maximumLengthSubstring(s)
}

/**
 * Объяснение:
 *
 * Подход со скользящим окном: Использую два указателя (left и right) для поддержания валидного окна,
 * где каждый символ встречается не более двух раз.
 *
 * Отслеживание частоты: Использую массив целых чисел размером 26 (для букв от 'a' до 'z') для отслеживания частоты
 * символов в текущем окне.
 *
 * Расширение окна: Для каждого нового символа (на позиции right) я добавляю его в окно, увеличивая его счетчик частоты.
 *
 * Сужение окна: Если добавление нового символа приводит к тому, что он встречается более двух раз, я сужаю окно
 * слева до тех пор, пока счетчик снова не станет валидным (<= 2).
 *
 * Вычисление длины: После каждой корректировки окна я вычисляю текущую длину окна и обновляю максимальную длину.
 *
 * Временная сложность: O(n), где n - длина строки. Каждый символ обрабатывается не более двух раз
 * (один раз при добавлении в окно, один раз при удалении).
 *
 * Пространственная сложность: O(1), так как используется массив фиксированного размера из 26 целых чисел.
 */
fun maximumLengthSubstring(s: String): Int {
    var maxLength = 0
    val charCount = IntArray(26) // массив для хранения количества символов

    var left = 0
    for (right in s.indices) {
        // добавляем текущий символ в окно
        val currentChar = s[right]
        charCount[currentChar - 'a']++

        // двигаем окно вправо пока какой-либо символ встречается более 2 раз
        while (charCount[currentChar - 'a'] > 2) {
            val leftChar = s[left]
            charCount[leftChar - 'a']--
            left++
        }

        // обновляем длину подстроки
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}