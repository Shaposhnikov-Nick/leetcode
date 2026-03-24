/**
 * 409 Longest Palindrome
 *
 * Easy
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
fun main() {
    val s = "abccccdd"
    longestPalindrome(s)
}

/**
 * Чтобы определить, когда буква из заданной строки может быть частью самого длинного палиндрома, рассмотрим наши примеры палиндромов:
 *
 * "acbbca": в палиндроме четной длины каждый символ должен встречаться четное количество раз.
 * "мадам": в палиндроме нечетной длины один дополнительный символ может быть засчитан в качестве центрального символа.
 *
 * Алгоритм
 * Инициализируйте карту frequencyMap для хранения частоты встречаемости каждого символа.
 * Подсчитайте частоту встречаемости каждого символа в s.
 * Инициализация переменных:
 * res для хранения длины самого длинного палиндрома.
 * hasOdd флаг для проверки наличия символа с нечетной частотой.
 * Пройдите циклом по частоте freq каждого символа:
 * Если freq значение четное, добавьте его к res.
 * Если значение freq нечетное, добавьте freq-1 к res и установите значение hasOdd равным true.
 * Если hasOdd значение равно true, вернуть res+1, в противном случае вернуть res.
 */
fun longestPalindrome(s: String): Int {
    //  map для хранения частоты встречаемых символов
    val frequencyMap = mutableMapOf<Char, Int>()
    // максимальная длина палиндрома
    var length = 0
    // флаг, что палиндром будет нечетной длины
    var hasOdd = false

    // считаем количество каждого символа в строке
    for (ch in s) {
        frequencyMap.merge(ch, 1, Int::plus)
    }

    // проходим по всем значениям частот
    frequencyMap.values.forEach { value ->
        length += if (value % 2 == 0)
        // если символ встречается четное количество раз, просто добавляем их к длине палиндрома
            value
        else {
            // если символ встречается нечетное количесво раз, добавляем к длине  это значение - 1
            // и ставим флаг, что палиндром будет нечетной длины
            hasOdd = true
            value - 1
        }
    }

    // если палиндром нечетной длины, добавляем к дилне 1
    return if (hasOdd) ++length else length
}