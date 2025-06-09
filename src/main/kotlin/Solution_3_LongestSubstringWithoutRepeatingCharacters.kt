import kotlin.math.max

/**
 * 3 Longest Substring Without Repeating Characters
 * Medium
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
fun main() {
    val s = "rt"
    println(lengthOfLongestSubstring(s))
}

fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    val map = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        map[s[i]] = 1
        var j = i + 1
        while (j < s.length) {
            val count = map.putIfAbsent(s[j], 1)
            if (count != null) {
                maxLength = max(maxLength, map.size)
                map.clear()
                break
            }
            j++
        }
    }

    return max(maxLength, map.size)
}

