/**
 * 268 Missing Number
 *
 * Easy
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 *
 * Output: 2
 *
 * Explanation:
 *
 * n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 *
 * Output: 2
 *
 * Explanation:
 *
 * n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 3:
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 *
 * Output: 8
 *
 * Explanation:
 *
 * n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 */
fun main() {
    val nums = intArrayOf(3, 0, 1)
    missingNumber(nums)
}

/**
 * - Сортируем массив по возрастанию
 * - Проверяем первый и последний элементы отсортированного массива
 * - Проверяем каждое число, что оно равно сумме предыдущего числа плюс 1
 */
fun missingNumber(nums: IntArray): Int {
    // сортируем массив по возрастанию
    nums.sort()
    val n = nums.size
    // проверяем первый и последний элементы отсортированного массива
    if (nums[0] != 0) return 0
    if (nums[n - 1] != n) return n

    // проверяем каждое число, что оно равно сумме предыдущего числа плюс 1
    for (i in 1 until n) {
        if (nums[i] != nums[i - 1] + 1) {
            return nums[i - 1] + 1
        }
    }

    return -1
}