/**
 * 500. Keyboard Row
 *
 * Easy
 *
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 *
 * Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 *
 * Output: ["Alaska","Dad"]
 *
 * Explanation:
 *
 * Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.
 *
 * Example 2:
 *
 * Input: words = ["omk"]
 *
 * Output: []
 *
 * Example 3:
 *
 * Input: words = ["adsdf","sfd"]
 *
 * Output: ["adsdf","sfd"]
 *
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] consists of English letters (both lowercase and uppercase).
 */
fun main() {
    val words = arrayOf("Hello", "Alaska", "Dad", "Peace")
    findWords(words)
}

/**
 * Преобразовываем буквы каждой строки клавиатуры в set
 * Проверяем, если ли все символы из слова в соответствующей строке клавиатуры
 */
fun findWords(words: Array<String>): Array<String> {
    // Преобразовываем буквы каждой строки клавиатуры в set
    val set1 = "qwertyuiop".toSet()
    val set2 = "asdfghjkl".toSet()
    val set3 = "zxcvbnm".toSet()
    val result = mutableListOf<String>()

    words.forEach { word ->
        // Проверяем, если ли все символы из слова в соответствующей строке клавиатуры
        // Если есть совпадения хоть в одной строке, добавляем слово в result
        if (checkWordInSet(word, set1) || checkWordInSet(word, set2) || checkWordInSet(word, set3)) result.add(word)
    }

    return result.toTypedArray()
}

private fun checkWordInSet(word: String, set: Set<Char>): Boolean {
    for (ch in word) {
        if (ch.lowercaseChar() !in set) return false
    }
    return true
}