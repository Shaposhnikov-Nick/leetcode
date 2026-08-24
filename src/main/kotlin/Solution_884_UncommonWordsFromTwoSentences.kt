/**
 * 884 Uncommon Words from Two Sentences
 *
 * Easy
 *
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
 *
 * Output: ["sweet","sour"]
 *
 * Explanation:
 *
 * The word "sweet" appears only in s1, while the word "sour" appears only in s2.
 *
 * Example 2:
 *
 * Input: s1 = "apple apple", s2 = "banana"
 *
 * Output: ["banana"]
 *
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 200
 * s1 and s2 consist of lowercase English letters and spaces.
 * s1 and s2 do not have leading or trailing spaces.
 * All the words in s1 and s2 are separated by a single space.
 */
fun main() {
    val s1 = "this apple is sweet"
    val s2 = "this apple is sour"
    uncommonFromSentences(s1, s2)
}

/**
 * Добавляем слова из первого и второго предложения в мапу, подсчитывая количество совпадающих слов.
 * Возвращаем список слов, которые встретились один раз
 */
fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val frequencyMap = mutableMapOf<String, Int>()

    for (word in s1.split(" ")){
        frequencyMap.merge(word, 1, Int::plus)
    }

    for (word in s2.split(" ")){
        frequencyMap.merge(word, 1, Int::plus)
    }

    return frequencyMap.filter { it.value == 1 }.keys.toTypedArray()
}