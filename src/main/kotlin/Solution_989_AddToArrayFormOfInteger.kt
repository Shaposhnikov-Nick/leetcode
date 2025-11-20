import java.math.BigInteger

/**
 * 989 Add to Array-Form of Integer
 *
 * Easy
 *
 * The array-form of an integer num is an array representing its digits in left to right order.
 *
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 *
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 *
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 *
 * Constraints:
 *
 * 1 <= num.length <= 104
 * 0 <= num[i] <= 9
 * num does not contain any leading zeros except for the zero itself.
 * 1 <= k <= 104
 */
fun main() {
    val num = intArrayOf(2, 1, 5)
    val k = 806
    addToArrayForm(num, k)
}

/**
 * Медленное, но идиоматичное решение
 * 1. Преобразовываем массив цифр в toBigInteger
 * 2. Добавляем к нему k
 * 3. Преобразовываем получившийся toBigInteger в список Int
 */
fun addToArrayForm(num: IntArray, k: Int): List<Int> {
    val numValue = num.joinToString(separator = "").toBigInteger()
    val sum = numValue.plus(k.toBigInteger())
    return sum.toString().toCharArray().map { it.toString().toInt() }
}

/**
 * Быстрое решение
 *
 * Алгоритм работы:
 *
 * Инициализация: Создаем список для результата и переменную carry, которая изначально равна k и будет хранить сумму с переносом.
 *
 * Основной цикл: Проходим по массиву справа налево (от младших разрядов к старшим) до тех пор, пока не обработаем все цифры массива и не исчерпаем перенос.
 *
 * Сложение разрядов:
 *
 * Если в массиве еще есть цифры, добавляем текущую цифру к carry
 *
 * Берем младший разряд результата (carry % 10) и добавляем в список
 *
 * Сохраняем старший разряд для переноса (carry / 10)
 *
 * Корректировка результата: Так как мы добавляли цифры с младших разрядов, разворачиваем список перед возвратом.
 */
fun addToArrayForm2(num: IntArray, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    var carry = k
    var i = num.size - 1

    // Проходим по массиву справа налево и добавляем k
    while (i >= 0 || carry > 0) {
        // Если еще есть цифры в массиве, добавляем их
        if (i >= 0) {
            carry += num[i]
            i--
        }
        // Добавляем младший разряд в результат
        result.add(carry % 10)
        // Переносим старший разряд
        carry /= 10
    }
    // Разворачиваем результат, так как добавляли с младших разрядов

    return result.reversed()
}