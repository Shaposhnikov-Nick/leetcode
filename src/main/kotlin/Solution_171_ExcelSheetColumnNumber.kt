/**
 * 171. Excel Sheet Column Number
 *
 * Easy
 *
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnTitle = "A"
 * Output: 1
 * Example 2:
 *
 * Input: columnTitle = "AB"
 * Output: 28
 * Example 3:
 *
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 *
 * Constraints:
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 */
fun main() {
    val columnTitle = "AB"
    titleToNumber(columnTitle)
}

/**
 * Это классическая задача на перевод числа из системы счисления с основанием 26, но с особенностью:
 * в Excel нет нуля.
 *
 * Соответствие такое:
 *
 * A = 1
 * B = 2
 * ...
 * Z = 26
 * AA = 27 = 1*26 + 1
 * AB = 28 = 1*26 + 2
 *
 * То есть строка читается как число в 26-ичной системе, где:
 *
 * value = char - 'A' + 1
 *
 * Алгоритм такой же, как перевод числа из любой системы счисления:
 *
 * result = result * 26 + value
 */
fun titleToNumber(columnTitle: String): Int {
    var result = 0

    for (c in columnTitle) {
        // переводим символ в его значение
        // Например если  c = 'C' то
        // 'C' - 'A'
        // 67 - 65 = 2
        val value = c - 'A' + 1
        result = result * 26 + value
    }

    return result
}