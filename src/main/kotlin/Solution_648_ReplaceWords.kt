/**
 * 648  Replace Words
 * Medium
 *
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 * Example 1:
 *
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Example 2:
 *
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 *
 *
 * Constraints:
 *
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] consists of only lower-case letters.
 * 1 <= sentence.length <= 106
 * sentence consists of only lower-case letters and spaces.
 * The number of words in sentence is in the range [1, 1000]
 * The length of each word in sentence is in the range [1, 1000]
 * Every two consecutive words in sentence will be separated by exactly one space.
 * sentence does not have leading or trailing spaces.
 */
fun main() {
    val dictionary = listOf("cat", "bat", "rat")
    val sentence = "the cattle was rattled by the battery"
    replaceWords(dictionary, sentence)
}

/**
 * Через Хеш-сет (Простой и интуитивный)
 * Подготовка: Помещаем все корни из dictionary в хеш-сет (HashSet / Set). Это позволяет проверять наличие корня
 * за время $O(1)$ в среднем.
 *
 * Разбиение предложения: Разбиваем строку sentence на отдельные слова по пробелам.
 * Обработка каждого слова: Для текущего слова перебираем все его префиксы, начиная с длины 1 и увеличивая длину на единицу:
 * Для слова cattle: проверяем префикс c, затем ca, затем cat и так далее.
 * На каждом шаге проверяем: есть ли такой префикс в нашем сете? Как только находим первое совпадение, сразу останавливаемся —
 * так как мы идем от меньшей длины к большей, первый найденный корень гарантированно будет самым коротким.
 * Если дошли до конца слова и совпадений не нашли, оставляем исходное слово.Сборка результата: Соединяем обработанные слова обратно через пробел.
 */
fun replaceWords(dictionary: List<String>, sentence: String): String {
    val result = StringBuilder()
    val roots = dictionary.toSet()
    val words = sentence.split(" ")

    for (word in words) {
        var hasRoot = false
        for (i in 1 until word.length) {
            val subStr = word.substring(0, i)
            // если часть слова есть в списке корней
            if (subStr in roots) {
                // добавляем корень в результат
                result.append("$subStr ")
                hasRoot = true
                break
            }
        }

        // если корня нет, добавляем все слово в результат
        if (!hasRoot) result.append("$word ")
    }

    return result.toString().trim()
}