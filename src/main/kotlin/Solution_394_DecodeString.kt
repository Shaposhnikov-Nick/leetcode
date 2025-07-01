/**
 * 394 Decode String
 *
 * Medium
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
fun main() {
    val s = "3[a]2[bc]"
    println(decodeString(s))
}

/**
 * Объяснение решения:
 *
 * Использование стека: Мы используем стек для хранения символов в процессе обработки.
 *
 * Обработка символов:
 *
 * Все символы, кроме ']', просто добавляются в стек.
 *
 * При встрече ']' начинается процесс декодирования:
 *
 * Извлекаем символы из стека до открывающей скобки '[', формируя декодируемую строку.
 *
 * Удаляем саму открывающую скобку.
 *
 * Извлекаем все цифры перед скобкой для получения числа повторений.
 *
 * Повторяем декодированную строку нужное количество раз.
 *
 * Помещаем результат обратно в стек для возможной дальнейшей обработки.
 *
 * Финальный результат: После обработки всех символов объединяем оставшиеся в стеке символы в итоговую строку.
 *
 * Пример работы для строк
 */
fun decodeString(s: String): String {
    val stack = ArrayDeque<Char>()

    for (char in s) {
        if (char != ']') {
            stack.addLast(char) // Добавляем символ в стек, если это не закрывающая скобка
        } else {
            // Обрабатываем закодированную строку
            val decodedString = StringBuilder()
            // Извлекаем символы до открывающей скобки
            while (stack.isNotEmpty() && stack.last() != '[') {
                decodedString.insert(0, stack.removeLast())
            }
            // Удаляем открывающую скобку '['
            stack.removeLast()

            // Извлекаем цифры для получения коэффициента повторения
            val countStr = StringBuilder()
            while (stack.isNotEmpty() && stack.last().isDigit()) {
                countStr.insert(0, stack.removeLast())
            }
            val count = countStr.toString().toInt()

            // Повторяем строку и помещаем обратно в стек
            val repeatedString = decodedString.toString().repeat(count)
            repeatedString.forEach { stack.addLast(it) }
        }
    }

    return stack.joinToString("") // Собираем итоговую строку из стека
}