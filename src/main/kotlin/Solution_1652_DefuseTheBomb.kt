/**
 * 1652 Defuse the Bomb
 *
 * Easy
 *
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 *
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 *
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 *
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 *
 * Example 1:
 *
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 * Example 2:
 *
 * Input: code = [1,2,3,4], k = 0
 * Output: [0,0,0,0]
 * Explanation: When k is zero, the numbers are replaced by 0.
 * Example 3:
 *
 * Input: code = [2,4,9,3], k = -2
 * Output: [12,5,6,13]
 * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 *
 * Constraints:
 *
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 */
fun main() {
    val code = intArrayOf(5, 7, 1, 4)
    val k = 3
//
//    val code = intArrayOf(2,4,9,3)
//    val k = -2

//    val code = intArrayOf(1,2,3,4)
//    val k = 0

    println(decrypt(code, k).contentToString())
}

/**
 * Объяснение решения:
 *
 * Случай k = 0: Просто возвращаем массив нулей той же длины.
 *
 * Случай k > 0: Для каждого элемента code[i] вычисляем сумму следующих k элементов. Используем оператор % для обработки циклического поведения массива.
 *
 * Случай k < 0: Для каждого элемента code[i] вычисляем сумму предыдущих |k| элементов. Также используем % для циклического доступа к элементам.
 */
fun decrypt(code: IntArray, k: Int): IntArray {
    val n = code.size
    val result = IntArray(n)

    when {
        k == 0 -> {
            // Если k = 0, все элементы заменяются на 0
            return IntArray(n) { 0 }
        }

        k > 0 -> {
            // Если k > 0, заменяем i-й элемент суммой следующих k элементов
            for (i in 0 until n) {
                var sum = 0
                for (j in 1..k) {
                    val index = (i + j) % n
                    sum += code[index]
                }
                result[i] = sum
            }
        }

        else -> {
            // Если k < 0, заменяем i-й элемент суммой предыдущих |k| элементов
            val absK = -k
            for (i in 0 until n) {
                var sum = 0
                for (j in 1..absK) {
                    val index = (i - j + n) % n
                    sum += code[index]
                }
                result[i] = sum
            }
        }
    }

    return result

}