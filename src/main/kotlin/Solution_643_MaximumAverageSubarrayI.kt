import kotlin.math.max

/**
 * 643 Maximum Average Subarray I
 *
 * Easy
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 */
fun main() {
    val nums = intArrayOf(1, 12, -5, -6, 50, 3)
    val k = 4
    println(findMaxAverage(nums, k))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var maxSum: Double
    var currentSum = 0.0
    var left = 0

    // сначала считаем сумму первого окна
    for (i in left until k) currentSum += nums[i]

    maxSum = currentSum

    for (i in k until nums.size) {
        // из текущей суммы вычитаем левое значение и прибавляем правое
        currentSum += (-nums[left] + nums[i])
        maxSum = max(currentSum, maxSum)
        left++
    }

    return maxSum / k
}