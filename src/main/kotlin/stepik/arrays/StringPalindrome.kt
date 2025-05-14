package stepik.arrays

fun main() {
    val s = readln()
    println(isPalindrome(s))
}

/**
 * Проверка, что слово - палиндром
 */
fun isPalindrome(s: String): Boolean {
    for (i in s.indices) {
        if (s[i] != s[s.length - 1 - i]) return false
    }

    return true
}

/**
 * Using reverse
 */
fun isPalindrome2(s: String): Boolean {
    return s == s.reversed()
}
