import kotlin.math.max

/**
 * 485 Max Consecutive Ones
 *
 * Easy
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 */
fun main() {
    val nums = intArrayOf(1, 0, 1, 1, 0, 1)
    println(findMaxConsecutiveOnes(nums))
}

// two pointers
fun findMaxConsecutiveOnes2(nums: IntArray): Int {
    var maxCount = 0
    var startIndex = 0
    var endIndex = 0

    while (endIndex < nums.size) {
        //find start of sequence 1
        while (endIndex < nums.size && nums[startIndex] == 0) {
            startIndex++
            endIndex++
        }

        // find end of sequence 1
        while (endIndex < nums.size && nums[endIndex] == 1) {
            endIndex++
        }

        val currentCount = endIndex - startIndex
        maxCount = max(currentCount, maxCount)
        startIndex = endIndex
        endIndex++
    }
    return maxCount
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxCount = 0
    var currentCount = 0

    for (num in nums) {
        if (num == 1) {
            currentCount++
        } else {
            maxCount = max(currentCount, maxCount)
            currentCount = 0
        }
    }

    return max(maxCount, currentCount)
}