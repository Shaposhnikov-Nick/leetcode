/**
 * 9 Palindrome Number
 *
 * Easy
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
fun main() {
    val x = -121
    println(isPalindrome(x))
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    var num = x
    val digits = mutableListOf<Int>()

    while (num != 0) {
        val digit = num % 10
        digits.add(digit)
        num /= 10
    }

    for (i in digits.indices) {
        if (digits[i] != digits[digits.size - 1 - i]) return false
    }

    return true
}

/**
 * Using toString()
 */
fun isPalindrome2(x: Int): Boolean {
    val str = x.toString()
    return str == str.reversed()
}