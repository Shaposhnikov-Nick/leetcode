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