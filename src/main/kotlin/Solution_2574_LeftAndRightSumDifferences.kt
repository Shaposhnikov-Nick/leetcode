import kotlin.math.abs

/**
 * 2574 Left and Right Sum Differences
 *
 * Easy
 *
 * You are given a 0-indexed integer array nums of size n.
 *
 * Define two arrays leftSum and rightSum where:
 *
 * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
 * Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,4,8,3]
 * Output: [15,1,11,22]
 * Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
 * The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [0]
 * Explanation: The array leftSum is [0] and the array rightSum is [0].
 * The array answer is [|0 - 0|] = [0].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 */
fun main() {
    val nums = intArrayOf(10, 4, 8, 3)
    leftRightDifference(nums)
}

/**
 * Сначала проходим слева направо и считаем префиксные суммы элементов слева от i
 * Затем проходим справа налево и считаем префиксные суммы справа от i
 * Находим разницу сумм
 */
fun leftRightDifference(nums: IntArray): IntArray {
    val n = nums.size
    val leftSum = IntArray(n)
    val rightSum = IntArray(n)
    val answer = IntArray(n)

    // считаем префиксные суммы элементов слева от i
    for (i in nums.indices) {
        if (i == 0) leftSum[i] = 0
        else leftSum[i] = leftSum[i - 1] + nums[i - 1]
    }

    // считаем префиксные суммы справа от i
    for (i in nums.indices.reversed()) {
        if (i == n - 1) rightSum[i] = 0
        else rightSum[i] = rightSum[i + 1] + nums[i + 1]
    }

    // находим разницу сумм
    for (i in answer.indices) {
        answer[i] = abs(leftSum[i] - rightSum[i])
    }

    return answer
}