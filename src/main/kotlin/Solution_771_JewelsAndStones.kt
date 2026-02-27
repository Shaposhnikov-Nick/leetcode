/**
 * 771 Jewels and Stones
 *
 * Easy
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 *
 *
 * Example 1:
 *
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= jewels.length, stones.length <= 50
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 */
fun main() {
    val jewels = "aA"
    val stones = "aAAbbbb"
    numJewelsInStones(jewels, stones)
}

/**
 * Добавляем jewels в set
 * Если камень есть в set, увеличиваем счетчик
 */
fun numJewelsInStones(jewels: String, stones: String): Int {
    var jewelsCount = 0
    val set = mutableSetOf<Char>()

    // Добавляем jewels в set
    for (ch in jewels) {
        set.add(ch)
    }

    for (stone in stones) {
        // Если камень есть в set, увеличиваем счетчик
        if (stone in jewels) jewelsCount++
    }

    return jewelsCount
}

fun numJewelsInStones2(jewels: String, stones: String): Int {
    return stones.count { it in jewels }
}