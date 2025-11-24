/**
 * 209 Minimum Size Subarray Sum
 *
 * Medium
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
fun main() {
    val nums = intArrayOf(2, 3, 1, 2, 4, 3)
    val target = 7
    minSubArrayLen(target, nums)
}

/**
 * Алгоритм:
 *
 * Инициализация: Используем два указателя left и right, текущую сумму currentSum и переменную для минимальной длины minLength
 *
 * Расширение окна: Правый указатель right движется по массиву, добавляя элементы к текущей сумме
 *
 * Сужение окна: Когда текущая сумма становится больше или равна target, начинаем двигать левый указатель left, уменьшая сумму и обновляя минимальную длину
 *
 * Результат: Если подходящий подмассив найден, возвращаем минимальную длину, иначе 0
 */
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var currentSum = 0
    var minLength = Int.MAX_VALUE

    for (right in nums.indices) {
        currentSum += nums[right]

        while (currentSum >= target) {
            minLength = minOf(minLength, right - left + 1)
            currentSum -= nums[left]
            left++
        }
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}