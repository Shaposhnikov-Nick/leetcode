/**
 * 38 Count and Say
 *
 * Medium
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 *
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 *
 *
 * Example 1:
 *
 * Input: n = 4
 *
 * Output: "1211"
 *
 * Explanation:
 *
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 *
 * Example 2:
 *
 * Input: n = 1
 *
 * Output: "1"
 *
 * Explanation:
 *
 * This is the base case.
 */
fun main() {
    val n = 4
    println(countAndSay(n))
}

/**
 * Алгоритм решения:
 *
 * Базовый случай: если n = 1, возвращаем "1"
 *
 * Для n > 1 рекурсивно получаем предыдущую строку
 *
 * Для полученной строки применяем RLE-кодирование:
 *
 * Проходим по строке, подсчитывая количество последовательных одинаковых цифр
 *
 * Формируем новую строку, добавляя количество и саму цифру для каждой группы
 */
fun countAndSay(n: Int): String {
    if (n == 1) return "1"
    val prev = countAndSay(n - 1)
    val result = StringBuilder()
    var count = 1
    for (i in prev.indices) {
        if (i + 1 < prev.length && prev[i] == prev[i + 1]) {
            count++
        } else {
            result.append(count).append(prev[i])
            count = 1
        }
    }
    return result.toString()
}