/**
 * 1248 Count Number of Nice Subarrays
 *
 * Medium
 *
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
fun main() {
    val nums = intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2)
    val k = 2
    numberOfSubarrays(nums, k)
}

/**
 * Для упрощения подсчета заменим четные числа на 0, нечетные на 1.
 * Используем скользящие окна размеров от k до nums.size.
 * Проходим скользящим окном по массиву слева направо. Для первого окна размером k считаем сумму этого окна,
 * для остальных окон k+1..n добавляем к этой сумме nums[k+1], чтобы не пересчитывать ее каждый раз заново.
 * Двигаем скользящее окно, если сумма в окне равна k, считаем этот подмассив подхоядщим
 */
fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    // счетчик количества подходящих подмассивов
    var niceSubarray = 0
    var windowSum = 0

    // заменим четные числа на 0, нечетные на 1
    for (i in nums.indices) {
        nums[i] = if (nums[i] % 2 == 0) 0 else 1
    }

    // берем скользящие окна размером от k до nums.size
    for (windowLength in k..nums.size) {
        var prefixSum = 0
        var left = 0
        var right = 0

        // для первого окна считаем сумму в окне
        if (windowLength == k) {
            while (right < windowLength) {
                prefixSum += nums[right]
                right++
            }

            // запоминаем для последующих окон
            windowSum = prefixSum
        } else {
            // для следующих окон находим их сумму путем добавления следующего числа к сумме предыдущего окна
            windowSum += nums[windowLength - 1]
            prefixSum = windowSum
            right = windowLength
        }

        // если сумма в окне равна искомой, увеличиваем счетчик
        if (prefixSum == k) {
            niceSubarray++
        }

        // двигаем окно и считаем сумму в нем
        while (right < nums.size) {
            prefixSum = prefixSum + nums[right] - nums[left]
            // если сумма в окне равна искомой, увеличиваем счетчик
            if (prefixSum == k) niceSubarray++
            left++
            right++
        }
    }

    return niceSubarray
}