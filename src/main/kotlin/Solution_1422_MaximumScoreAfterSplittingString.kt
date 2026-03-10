import kotlin.math.max

/**
 * 1422 Maximum Score After Splitting a String
 *
 * Easy
 *
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
 *
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 * Example 2:
 *
 * Input: s = "00111"
 * Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 * Example 3:
 *
 * Input: s = "1111"
 * Output: 3
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 500
 * The string s consists of characters '0' and '1' only.
 */
fun main() {
    val s = "00"
    maxScore(s)
}

/**
 * Проходим строку и считаем префиксные суммы единиц и префиксные суммы нулей для каждого индекса
 * Проходим по массивам с префиксными сумма и складываем из массива с префиксами нулей и
 * количестве единиц справа от индекса (как разность максимального количества единиц и количества единиц слева)
 */
fun maxScore(s: String): Int {
    val n = s.length
    val onePrefixSum = IntArray(n) { 0 }
    val zeroPrefixSum = IntArray(n) { 0 }
    var maxSum = 0

    // определяем префиксную сумму для 0 индекса
    if (s[0].digitToInt() == 1)
        onePrefixSum[0] = 1
    else
        zeroPrefixSum[0] = 1

    // Проходим строку с 1 индекса и считаем префиксные суммы единиц и префиксные суммы нулей для каждого индекса
    // Например для строки      "011101"
    // Префиксные суммы единиц   012334
    // префиксные суммы нулей    111122
    for (i in 1 until n) {
        if (s[i].digitToInt() == 1) {
            onePrefixSum[i] = onePrefixSum[i - 1] + 1
            zeroPrefixSum[i] = zeroPrefixSum[i - 1]
        } else {
            onePrefixSum[i] = onePrefixSum[i - 1]
            zeroPrefixSum[i] = zeroPrefixSum[i - 1] + 1
        }
    }

    // Проходим по массивам с префиксными сумма и складываем из массива с префиксами нулей слева от индекса и
    // количестве единиц справа от индекса (как разность максимального количества единиц и количества единиц слева)
    for (i in 0 until n - 1) {
        val zeroCount = zeroPrefixSum[i]
        val oneCount = onePrefixSum[n - 1] - onePrefixSum[i]
        val sum = zeroCount + oneCount
        maxSum = max(maxSum, sum)
    }

    return maxSum
}