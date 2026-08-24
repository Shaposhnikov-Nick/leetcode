/**
 * 1160 Find Words That Can Be Formed by Characters
 *
 * Easy
 * T
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * words[i] and chars consist of lowercase English letters.
 */
fun main() {
    val words = arrayOf("cat", "bt", "hat", "tree")
    val chars = "atach"
    countCharacters(words, chars)
}

/**
 * Считаем количество символов в chars
 * Считаем количество символов в каждом слове
 * Сравниваем символы и их количество из слова с символами из chars, если в chars нет такого символа
 * или их количество меньше, то слово не подходит. Чтобы отметить что символ в слове был, умеьшаем
 * значение а wordFrequencyMap
 * В результате если слово подходит, количество совпадений его символов в wordFrequencyMap должно быть 0
 */
fun countCharacters(words: Array<String>, chars: String): Int {
    val charsFrequencyMap = mutableMapOf<Char, Int>()
    var result = 0

    // Считаем количество символов в chars
    chars.forEach { ch -> charsFrequencyMap.merge(ch, 1, Int::plus) }

    words.forEach { word ->
        var isApplicable = true
        val wordFrequencyMap = mutableMapOf<Char, Int>()

        // Считаем количество символов в каждом слове
        word.forEach { ch ->
            wordFrequencyMap.merge(ch, 1, Int::plus)
        }

        // Сравниваем символы и их количество из слова с символами из chars
        wordFrequencyMap.forEach { (ch, i) ->
            val count = charsFrequencyMap[ch]

            // если в chars нет такого символа или их количество меньше, то слово не подходит
            if (count == null || count < i)
                isApplicable = false
            else
            // Чтобы отметить что символ в слове был, умеьшаем значение а wordFrequencyMap
                wordFrequencyMap.merge(ch, 1, Int::minus)
        }

        // В результате если слово подходит, количество совпадений его символов в wordFrequencyMap должно быть 0
        if (isApplicable || wordFrequencyMap.all { it.value == 0 }) result += word.length
    }

    return result
}

/**
 * Более быстрое решение
 */
fun countCharacters2(words: Array<String>, chars: String): Int {
    val charCount = IntArray(26)
    var answer = 0
    for (c in chars) {
        charCount[c - 'a']++
    }
    for (word in words) {
        val needed = IntArray(26)
        var isGood = true
        for (ch in word) {
            needed[ch - 'a']++
        }
        for (i in 0..25) {
            if (needed[i] > charCount[i]) {
                isGood = false
                break
            }
        }
        if (isGood) {
            answer += word.length
        }
    }
    return answer
}