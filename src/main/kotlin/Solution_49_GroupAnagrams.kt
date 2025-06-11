import java.util.Arrays

/**
 * 49 Group Anagrams
 *
 * Medium
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 *
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 */
fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(strs).joinToString())
}

/**
 * В hashmap добавлятся значения по ключу, которой является отсортированным словом из strs
 */
/**
 * more idiomatic code on Kotlin
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    return strs.groupBy {
        val chars = it.toCharArray()
        Arrays.sort(chars)
        String(chars)
    }.values.toList()
}

fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    strs.forEach {
        val chars = it.toCharArray()
        Arrays.sort(chars)
        val sorted = String(chars)
        map.putIfAbsent(sorted, mutableListOf<String>())?.add(it)
    }

    return map.values.toList()
}




