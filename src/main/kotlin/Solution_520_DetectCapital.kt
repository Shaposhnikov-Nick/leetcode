import java.util.*

/**
 * 520 Detect Capital
 *
 * Easy
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 * Example 2:
 *
 * Input: word = "FlaG"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
fun main() {
    val word = "FlaG"
    detectCapitalUse(word)
}

/**
 * Преобразовываем исходное слово в
 * - все заглавные
 * - все прописные
 * - только первая заглавная
 *
 * Сравниваем исходное слово с преобразованными
 */
fun detectCapitalUse(word: String): Boolean {
    val allCapital = word.uppercase()
    val allAreNotCapital = word.lowercase()
    val onlyFirstCapital = allAreNotCapital.replaceRange(0, 1, allAreNotCapital[0].uppercase())

    return word == allCapital || word == allAreNotCapital || word == onlyFirstCapital

}

/**
 * Проверяем каждый символ и считаем количество заглавных
 *
 * возвращаем true если:
 * - все прописные (capitals = 0)
 * - только первый символ заглавный (capitals = 1)
 * - все символы заглавные (capitals == word.length)
 */
fun detectCapitalUse2(word: String): Boolean {
    var capitals = 0

    // считаем заглавные буквы
    for (char in word) {
        if (char.isUpperCase()) {
            capitals++
        }
    }

    return when (capitals) {
        0 -> true
        1 -> word[0].isUpperCase()
        else -> capitals == word.length
    }
}