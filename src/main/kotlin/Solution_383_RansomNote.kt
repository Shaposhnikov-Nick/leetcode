/**
 * 383 Ransom Note
 *
 * Easy
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
fun main() {
    val ransomNote = "aa"
    val magazine = "ab"
    canConstruct(ransomNote, magazine)
}

/**
 * можно ли из строки magazine получить строку ransomNote
 */
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    // считаем количество вхождений каждого символа в magazine
    val lettersCount = mutableMapOf<Char, Int>()

    for (letter in magazine) {
//        lettersCount.compute(letter) { key, value -> (value ?: 0) + 1 }
//        lettersCount.merge(letter, 1) { oldValue, newValue -> oldValue + newValue }
//        lettersCount.merge(letter, 1, Int::plus)

        lettersCount[letter] = lettersCount.getOrDefault(letter, 0) + 1 // так быстрее всего
    }

    // проверяем каждый символ из letter, что он есть в magazine и уменьшаем счетчик
    // если символа нет или его количество равно 0, возвращаем false
    for (letter in ransomNote) {
        var count = lettersCount[letter] ?: return false
        if (count == 0) return false
        lettersCount[letter] = --count
    }

    return true
}