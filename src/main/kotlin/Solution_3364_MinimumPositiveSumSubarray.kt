/**
 * 3364. Minimum Positive Sum Subarray
 *
 * Easy
 *
 * You are given an integer array nums and two integers l and r. Your task is to find the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0.
 *
 * Return the minimum sum of such a subarray. If no such subarray exists, return -1.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3, -2, 1, 4], l = 2, r = 3
 *
 * Output: 1
 *
 * Explanation:
 *
 * The subarrays of length between l = 2 and r = 3 where the sum is greater than 0 are:
 *
 * [3, -2] with a sum of 1
 * [1, 4] with a sum of 5
 * [3, -2, 1] with a sum of 2
 * [-2, 1, 4] with a sum of 3
 * Out of these, the subarray [3, -2] has a sum of 1, which is the smallest positive sum. Hence, the answer is 1.
 *
 * Example 2:
 *
 * Input: nums = [-2, 2, -3, 1], l = 2, r = 3
 *
 * Output: -1
 *
 * Explanation:
 *
 * There is no subarray of length between l and r that has a sum greater than 0. So, the answer is -1.
 *
 * Example 3:
 *
 * Input: nums = [1, 2, 3, 4], l = 2, r = 4
 *
 * Output: 3
 *
 * Explanation:
 *
 * The subarray [1, 2] has a length of 2 and the minimum sum greater than 0. So, the answer is 3.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= l <= r <= nums.length
 * -1000 <= nums[i] <= 1000
 */
fun main() {
    val nums = listOf(3, -2, 1, 4)
    val l = 2
    val r = 3
    minimumSumSubarray(nums, l, r)
}

/**
 * Для каждой длины подмассива ищем тот, который меньше всего в сумме элементов
 * Используем скользящее окно длиной от l до r (то есть длиной с каждый подмассив)
 * Считаем сумму для первого подмассива
 * Далее двигаем указатель на единицу вправо и считаем новую сумму подмассива: удаляем левое значение и прибавляем правое.
 * Каждый раз сравниваем получившееся значение с уже ранее найденным минимальным
 */
fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
    var minSum = -1

    // Для каждой длины подмассива ищем тот, который меньше всего в сумме элементов
    for (length in l..r) {
        // Текущая сумма каждого подмассива
        var currentMinSum = 0
        // Используем скользящее окно длиной от l до r (то есть длиной с каждый подмассив)
        var j = 0

        // Считаем префиксную сумму для первого подмассива
        while (j < length) {
            currentMinSum += nums[j]
            j++
        }
        // Сравниваем получившееся значение с уже ранее найденным минимальным или -1
        if (currentMinSum > 0) {
            minSum = if (minSum == -1) currentMinSum else minOf(minSum, currentMinSum)
        }

        // Далее двигаем указатель на единицу вправо и считаем новую сумму подмассива: удаляем левое значение и прибавляем правое.
        while (j < nums.size) {
            currentMinSum = currentMinSum + nums[j] - nums[j - length]
            // Каждый раз сравниваем получившееся значение с уже ранее найденным минимальным
            if (currentMinSum > 0) {
                minSum = if (minSum == -1) currentMinSum else minOf(minSum, currentMinSum)
            }
            j++
        }
    }

    return minSum
}

fun minimumSumSubarray2(nums: List<Int>, l: Int, r: Int): Int {
    val prefixSum = IntArray(nums.size + 1)

    prefixSum[0] = nums[0]

    for (i in 0 until nums.size) {
        prefixSum[i + 1] = prefixSum[i] + nums[i]
    }

    var result = Int.MAX_VALUE

    for (start in 0 until nums.size) {
        for (len in l..r) {
            val end = start + len

            if (end > nums.size) {
                break
            }

            val sum = prefixSum[end] - prefixSum[start]

            if (sum > 0) {
                result = minOf(result, sum)
            }
        }

    }
    return if (result == Int.MAX_VALUE) -1 else result
}