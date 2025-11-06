/**
 * 17 Letter Combinations of a Phone Number
 *
 * Medium
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
fun main() {
    val digits = "23"
    println(letterCombinations(digits))
}

/**
 * Объяснение алгоритма:
 *
 * Создаем mapping цифр к буквам согласно телефонной клавиатуре
 *
 * Итеративный подход:
 * Начинаем с пустого списка, содержащего одну пустую строку
 * Для каждой цифры создаем новые комбинации, добавляя все возможные буквы к существующим комбинациям
 *
 * Сложность:
 * Временная сложность: O(4^n), где n - длина строки digits
 */
fun letterCombinations(digits: String): List<String> {
    // 1. Проверяем пустой ввод
    if (digits.isEmpty()) return emptyList()

    // 2. Создаем mapping цифр к буквам (телефонная клавиатура)
    val phoneMap = mapOf(
        '2' to "abc",  // 2 -> a, b, c
        '3' to "def",  // 3 -> d, e, f
        '4' to "ghi",  // 4 -> g, h, i
        '5' to "jkl",  // 5 -> j, k, l
        '6' to "mno",  // 6 -> m, n, o
        '7' to "pqrs", // 7 -> p, q, r, s
        '8' to "tuv",  // 8 -> t, u, v
        '9' to "wxyz"  // 9 -> w, x, y, z
    )

    // 3. Инициализируем результат с одной пустой строкой
    var result = listOf("")

    // 4. Проходим по каждой цифре во входной строке
    for (digit in digits) {
        // 5. Создаем временный список для новых комбинаций
        val newResult = mutableListOf<String>()

        // 6. Получаем буквы для текущей цифры
        val letters = phoneMap[digit] ?: ""

        // 7. Для каждой существующей комбинации в результате
        for (combination in result) {
            // 8. Для каждой буквы, соответствующей текущей цифре
            for (letter in letters) {
                // 9. Создаем новую комбинацию и добавляем в временный список
                newResult.add(combination + letter)
            }
        }

        // 10. Заменяем старый результат новым списком комбинаций
        result = newResult
    }

    // 11. Возвращаем финальный результат
    return result
}

/**
 * Объяснение алгоритма:
 *
 * Создаем mapping цифр к буквам согласно телефонной клавиатуре
 *
 * Рекурсивный подход:
 * Начинаем с пустой строки
 * Для каждой цифры во входной строке добавляем все возможные буквы
 * Когда достигаем конца строки, добавляем комбинацию в результат
 *
 * Сложность:
 * Временная сложность: O(4^n), где n - длина строки digits
 * Пространственная сложность: O(n) для рекурсивного подхода (из-за стека вызовов)
 */
fun letterCombinations2(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val phoneMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    val result = mutableListOf<String>()

    fun backtrack(index: Int, currentCombination: StringBuilder) {
        if (index == digits.length) {
            result.add(currentCombination.toString())
            return
        }

        val digit = digits[index]
        val letters = phoneMap[digit] ?: ""

        for (letter in letters) {
            currentCombination.append(letter)
            backtrack(index + 1, currentCombination)
            currentCombination.deleteCharAt(currentCombination.length - 1)
        }
    }

    backtrack(0, StringBuilder())
    return result
}