/**
 * 125 Valid Palindrome
 *
 * Easy
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
fun main() {
    val s = "A man, a plan, a canal: Panama"
    println(isPalindrome(s))
}

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    while (left < right) {
        while (left < right && !s[left].isLetterOrDigit()) left++
        while (left < right && !s[right].isLetterOrDigit()) right--
        if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false
        left++
        right--
    }
    return true
}

fun isPalindrome2(s: String): Boolean {
    if (s.isBlank()) return true
    if (s.length == 1) return true
    val letters = buildString {
        for (char in s) {
            if (char.isLetterOrDigit()) append(char.lowercaseChar())
        }
    }

    for (i in letters.indices) {
        if (letters[i] != letters[letters.length - 1 - i]) return false
    }

    return true
}

