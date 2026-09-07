import kotlin.math.pow

/**
 * 476. Number Complement
 *
 * Easy
 *
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer num, return its complement.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 *
 * Input: num = 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
fun main() {
    val num = 13
    findComplement(num)
}

/**
 * Переводим число в двоичную систему счисления сразу изменяя 0 на 1 и 1 на 0
 * Переводим получившееся двоичное число обратно в десятичное
 */
fun findComplement(num: Int): Int {
    // Переводим число в двоичную систему счисления сразу изменяя 0 на 1 и 1 на 0
    val binary = buildString {
        var n = num
        while (n != 0) {
            val remainder = n % 2
            val inversedRemainder = if (remainder == 0) 1 else 0
            insert(0, inversedRemainder)
            n /= 2
        }
    }

    var result = 0.0
    // переводим получившееся двоичное число обратно в 10 систему счисления
    for (i in binary.indices) {
        val degree = 2.0.pow(i)
        val bit = binary[binary.length - 1 - i].toString().toInt()
        result += bit * degree
    }

    return result.toInt()
}