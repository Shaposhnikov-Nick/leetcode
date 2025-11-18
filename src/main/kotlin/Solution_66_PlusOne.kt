import java.math.BigInteger
import kotlin.time.times

/**
 * 66 Plus One
 *
 * Easy
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
fun main() {
    val digits = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    plusOne(digits)
}

/**
 * Объяснение решения:
 *
 * Проходим массив справа налево (от младшего разряда к старшему)
 *
 * Если текущая цифра меньше 9: просто увеличиваем её на 1 и возвращаем результат
 *
 * Если текущая цифра равна 9: устанавливаем её в 0 и продолжаем цикл (происходит "перенос")
 *
 * Особый случай - все цифры были 9: создаём новый массив на 1 элемент больше, где первый элемент = 1, остальные = 0
 */
fun plusOne(digits: IntArray): IntArray {
    for (i in digits.size - 1 downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }

    // Если мы дошли сюда, значит все цифры были 9
    val result = IntArray(digits.size + 1)
    result[0] = 1
    return result
}