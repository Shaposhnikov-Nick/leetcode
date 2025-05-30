/**
 * 151 Reverse Words in a String
 *
 * Medium
 *
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
fun main() {
    val s = "  a good   example   "
    println(reverseWords(s))
}

fun reverseWords(s: String): String {
    return buildString {
        var startIndex = 0
        var endIndex = 1

        while (startIndex < endIndex && endIndex <= s.length) {

            // find first index of word
            for (i in startIndex..<s.length)
                if (s[i].isWhitespace()) {
                    startIndex++
                    endIndex++
                } else {
                    break
                }

            // find last index of word
            for (i in startIndex + 1..<s.length) {
                if (!s[i].isWhitespace()) {
                    endIndex++
                } else {
                    break
                }
            }

            // substring
            if (startIndex < s.length && endIndex <= s.length) {
                val word = if (endIndex >= s.length)
                    s.substring(startIndex)
                else
                    s.substring(startIndex, endIndex)

                if (isEmpty())
                    insert(0, word)
                else
                    insert(0, "$word ")
            }

            startIndex = endIndex
            endIndex++
        }
    }
}

fun reverseWords2(s: String): String {
    return s.trim()
        .split(" ")
        .filter { it != "" }
        .reversed()
        .joinToString(separator = " ")
}