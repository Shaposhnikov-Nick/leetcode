/**
 * 557 Reverse Words in a String III
 *
 * Easy
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "Mr Ding"
 * Output: "rM gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
fun main() {
    val s = "Let's take LeetCode contest"
    reverseWordsIII2(s)
}

/**
 * Идиоматическое решение
 * Делим строку по пробелам в массив отдельных слов
 * Разворачиваем каждое слово и объединяем в новую строку
 */
fun reverseWordsIII(s: String): String {
    return s.split(" ").joinToString(separator = " ") { it.reversed() }
}

/**
 * Быстрое решение используя циклы и указатель
 */
fun reverseWordsIII2(s: String): String {
    // коллекция для хранения отлельных слов
    val words = mutableListOf<MutableList<Char>>()
    // указатель для обхода символов в строке
    var pointer = 0

    // проходим все символы в строке
    while (pointer < s.length) {
        val word = mutableListOf<Char>()
        // до пробела добавляем слово в отдельный лист
        // как только находим пробел, значиииит слово закончилось
        while (pointer < s.length && s[pointer] != ' ') {
            word += s[pointer]
            pointer++
        }
        // добавляем слово в виде массива символов
        words += word
        // двигаем указатель на следующий за пробелом символ
        pointer++
    }

    val sb = StringBuilder()

    // проходим по каждому листу с символами
    for (i in words.indices) {
        val chars = words[i]
        // меняем местами символы в массиве
        for (i in 0..<(chars.size / 2)) {
            val temp = chars[i]
            chars[i] = chars[chars.size - 1 - i]
            chars[chars.size - 1 - i] = temp
        }
        // преобразовываем символы в слово
        val word = String(chars.toCharArray())
        // добавляем слово в StringBuilder
        sb.append(word)
        // после каждого слова добавляем пробел
        sb.append(" ")
    }

    //удаляем пробел в конце и возвращаем полную строку
    return sb.deleteCharAt(s.length - 1).toString()
}