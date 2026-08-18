/**
 * 680 Valid Palindrome II
 *
 * Easy
 *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
fun main() {
    val s = "asdfdsa"
    validPalindrome(s)
}

/**
 * Проходим по строке с обоих концов навстречу и сравниваем символы.
 * Если доходим до первого несовпадения символов, пробуем удалить символ в начале или символ в конце
 * и проверить оставшуюся строку на палиндром. Если хотя бы одна подстрока после удаления одного символа  является палиндромом,
 * возвращаем true, иначе false
 */
fun validPalindrome(s: String): Boolean {
    var l = 0;
    var r = s.length - 1

    // Проходим по строке с обоих концов навстречу и сравниваем символы.
    while (l < r) {
        // Если доходим до первого несовпадения символов, пробуем удалить символ в начале или символ в конце
        if (s[l] != s[r]) {
            // проверяем оставшуюся строку на палиндром
            // Если хотя бы одна подстрока после удаления одного символа  является палиндромом, возвращаем true, иначе false
            return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)
        }
        l++
        r--
    }

    return true
}

// проверят, что строка - палиндром
fun isPalindrome(s: String, l: Int, r: Int): Boolean {
    var left = l
    var right = r
    while (left < right) {
        if (s[left] != s[right]) return false
        left++
        right--
    }

    return true
}