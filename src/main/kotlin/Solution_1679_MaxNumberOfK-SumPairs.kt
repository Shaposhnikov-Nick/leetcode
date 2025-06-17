import java.util.Arrays

/**
 * 1679 Max Number of K-Sum Pairs
 *
 * Medium
 *
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 *
 * Example 2:
 *
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 *
 * 1 <= nums[i] <= 109
 *
 * 1 <= k <= 109
 */
fun main() {
    val nums = intArrayOf(2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2)
    val k = 3
    println(maxOperations(nums, k))
}

/**
 * Отсортировать массив, установить указатели на краях массива.
 * Складывать крайние значения. Если их сумма равна k, сдвигать указатели внутри массива.
 * Если сумма больше k, уменьшить правое (бОльшее значение).
 * Если сумма меньше k, увеличить левое (меньшее значение)
 */
fun maxOperations(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var left = 0
    var right = nums.size - 1
    var counter = 0

    while (left < right) {
        val sum = nums[left] + nums[right]
        if (sum == k) {
            counter++
            left++
            right--
        } else if (sum > k) {
            right--
        } else {
            left++
        }
    }

    return counter
}

/**
 * O(n2)
 */
fun maxOperations2(nums: IntArray, k: Int): Int {
    var counter = 0

    for (i in nums.indices) {
        val temp = nums[i]
        if (temp < 0) continue
        val findValue = k - temp
        if (findValue <= 0) continue
        nums[i] = -1
        val findValueIndex = nums.indexOf(findValue)
        if (i == findValueIndex) continue
        if (findValueIndex != -1) {
            counter++
            nums[findValueIndex] = -1
        } else {
            nums[i] = temp
        }
    }

    return counter
}