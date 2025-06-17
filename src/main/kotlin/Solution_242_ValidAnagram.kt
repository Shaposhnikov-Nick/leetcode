/**
 * 242 Valid Anagram
 *
 * Easy
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 */
fun main() {
    val s = "aacc"
    val t = "ccac"
    println(isAnagram(s, t))
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val map = HashMap<Char, Int>()

    for (ch in s) {
        map[ch] = map.getOrDefault(ch, 0) + 1
    }

    for (ch in t) {
        var count = map[ch]
        if (count == null || count == 0) return false
        map[ch] = --count
    }

    return true
}

fun isAnagram2(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val sArr = s.toCharArray().sorted()
    val tArr = t.toCharArray().sorted()

    for (i in sArr.indices) {
        if (sArr[i] != tArr[i]) return false
    }

    return true
}