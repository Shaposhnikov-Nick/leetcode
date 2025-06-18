/**
 * 258 Add Digits
 *
 * Easy
 *
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 *
 * Example 2:
 *
 * Input: num = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= num <= 231 - 1
 */
fun main() {
    val num = 38254
    println(addDigits(num))
}

/**
 * Объяснение:
 *
 * Цифровой корень числа можно вычислить с помощью формулы:
 *
 * Если число равно 0, то цифровой корень равен 0.
 *
 * Если число делится на 9 без остатка, то цифровой корень равен 9.
 *
 * В остальных случаях цифровой корень равен остатку от деления числа на 9.
 *
 * Этот подход основан на свойстве цифрового корня в десятичной системе счисления.
 *
 * Примеры:
 * Для числа 38:
 *
 * 38 % 9 = 2 (так как 3 + 8 = 11, а 1 + 1 = 2)
 *
 * Результат: 2
 *
 * Для числа 0:
 *
 * Результат: 0 (по условию)
 *
 * Для числа 9:
 *
 * 9 % 9 = 0, поэтому результат 9
 *
 * Это решение эффективно и работает за константное время O(1).
 */
fun addDigits(num: Int): Int {
    if (num == 0) return 0
    return if (num % 9 == 0) 9 else num % 9
}

fun addDigits2(num: Int): Int {
    if (num.toString().length == 1) return num
    var n = num
    var ans = 0

    while (n.toString().length > 1) {
        var temp = n
        ans = 0
        while (temp != 0) {
            val digit = temp % 10
            ans += digit
            temp /= 10
        }
        n = ans
    }

    return ans
}