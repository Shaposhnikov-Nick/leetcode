/**
 * 75 Sort Colors
 *
 * Medium
 *
 * You are given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 *
 * Output: [0,0,1,1,2,2]
 *
 * Explanation:
 *
 * The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.
 *
 * Example 2:
 *
 * Input: nums = [2,0,1]
 *
 * Output: [0,1,2]
 *
 * Explanation:
 *
 * The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1, 2.
 *
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
fun main() {
    val nums = intArrayOf(2, 0, 2, 1, 1, 0)
    sortColors(nums)
}

/**
 * Сортируем массив подсчетом
 * Считаем количество 0, 1 и 2
 * Перезаписываем ячейки в массиве в соответствии с подсчитанным количеством
 */
fun sortColors(nums: IntArray): Unit {
    var zeroCount = 0
    var oneCount = 0
    var twoCount = 0

    for (num in nums) {
        when (num) {
            0 -> zeroCount++
            1 -> oneCount++
            2 -> twoCount++
        }
    }

    for (i in nums.indices) {
        when {
            // интервал для 0
            i < zeroCount -> nums[i] = 0
            // интервал для 1
            i >= zeroCount && i < oneCount + zeroCount -> nums[i] = 1
            // интервал для 2
            i >= oneCount + zeroCount -> nums[i] = 2
        }
    }
}