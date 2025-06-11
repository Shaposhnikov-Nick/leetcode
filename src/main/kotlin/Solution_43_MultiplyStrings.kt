/**
 * 43 Multiply Strings
 *
 * Medium
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 *
 * Output: "6"
 *
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
fun main() {
    val num1 = "2"
    val num2 = "3"
    println(multiply(num1, num2))
}

fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"
    val m = num1.length
    val n = num2.length
    val result = IntArray(m + n)

    // Multiply each digit of num1 with each digit of num2
    for (i in m - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            val product = (num1[i] - '0') * (num2[j] - '0')
            val sum = product + result[i + j + 1]

            result[i + j + 1] = sum % 10
            result[i + j] += sum / 10
        }
    }

    // Convert the result array to a string, skipping leading zeros
    val sb = StringBuilder()
    for (digit in result) {
        if (sb.isNotEmpty() || digit != 0) {
            sb.append(digit)
        }
    }

    return sb.toString()
}
