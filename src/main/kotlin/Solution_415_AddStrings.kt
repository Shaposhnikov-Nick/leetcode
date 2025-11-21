/**
 * 415 Add Strings
 *
 * Easy
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 */
fun main() {
    val num1 = "456"
    val num2 = "77"
    addStrings(num1, num2)
}

/**
 * Решение аналогично задаче 67: Add Binary
 */
fun addStrings(num1: String, num2: String): String {
    var num1Index = num1.length - 1
    var num2Index = num2.length - 1
    val builder = StringBuilder()
    var carry = 0

    // Проходим по строкам справа налево
    while (num1Index >= 0 || num2Index >= 0 || carry > 0) {
        // Получаем текущие цифры (или 0 если строка закончилась)
        val num1Value = if (num1Index >= 0) num1[num1Index] - '0' else 0
        val num2Value = if (num2Index >= 0) num2[num2Index] - '0' else 0
        // Суммируем цифры и перенос
        val sum = num1Value + num2Value + carry
        // Вычисляем текущую цифру результата и новый перенос
        val digit = if (sum > 9) sum % 10 else sum
        carry = sum / 10
        builder.append(digit)

        // Переходим к следующим цифрам
        num1Index--
        num2Index--
    }

    // Разворачиваем строку, т.к. добавляли цифры с конца
    return builder.reversed().toString()
}

/**
 * Use BigInteger
 */
fun addStrings2(num1: String, num2: String): String {
    return num1.toBigInteger().plus(num2.toBigInteger()).toString()
}