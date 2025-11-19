/**
 * 67 Add Binary
 *
 * Easy
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
fun main() {
    val a = "1010"
    val b = "1011"
    addBinary(a, b)
}

/**
 * Объяснение алгоритма:
 *
 * Инициализация: Используем два указателя, которые начинаются с конца строк, и переменную carry для хранения переноса.
 *
 * Цикл обработки: Пока есть цифры в любой из строк или есть перенос:
 *
 * Получаем текущие цифры из обеих строк (или 0, если строка закончилась)
 *
 * Суммируем цифры и перенос
 *
 * Вычисляем текущую цифру результата (sum % 2)
 *
 * Обновляем перенос (sum / 2)
 *
 * Формирование результата: Так как мы обрабатываем числа справа налево, но добавляем цифры в прямом порядке, в конце нужно развернуть результат.
 */
fun addBinary(a: String, b: String): String {
    val result = StringBuilder()
    var aIndex = a.length - 1
    var bIndex = b.length - 1
    var carry = 0

    // Проходим по строкам справа налево
    while (aIndex >= 0 || bIndex >= 0 || carry > 0) {
        // Получаем текущие цифры (или 0 если строка закончилась)
        val aDigit = if (aIndex >= 0) a[aIndex] - '0' else 0
        val bDigit = if (bIndex >= 0) b[bIndex] - '0' else 0

        // Суммируем цифры и перенос
        val sum = aDigit + bDigit + carry

        // Вычисляем текущую цифру результата и новый перенос
        val newDigit = if (sum == 0 || sum == 2) 0 else 1
        carry = if (sum >= 2) 1 else 0
        result.append(newDigit)

//        result.append(sum % 2)
//        carry = sum / 2

        // Переходим к следующим цифрам
        aIndex--
        bIndex--
    }

    return result.reversed().toString()
}