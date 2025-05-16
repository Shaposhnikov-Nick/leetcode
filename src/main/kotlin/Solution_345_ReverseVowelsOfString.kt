/**
 * 345 Reverse Vowels of a String
 *
 * Easy
 *
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "IceCreAm"
 *
 * Output: "AceCreIm"
 *
 * Explanation:
 *
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 *
 * Output: "leotcede"
 */
fun main() {
    val s = "IceCreAm"
    println(reverseVowels(s))
}

fun reverseVowels(s: String): String {
    val vowels = arrayOf('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')
    val chars = s.toCharArray()
    var left = 0
    var right = chars.size - 1
    while (left < right) {
        while (left < right && chars[left] !in vowels) left++
        while (left < right && chars[right] !in vowels) right--
        val temp = chars[right]
        chars[right] = s[left]
        chars[left] = temp
        right--
        left++
    }
    return String(chars)
}