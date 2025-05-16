/**
 * 283 Move Zeroes
 * Easy
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 */
fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    println(moveZeroes(nums))
}

fun moveZeroes(nums: IntArray): Unit {
    var writeIndex = 0
    for (readIndex in nums.indices) {
        if (nums[readIndex] != 0) {
            nums[writeIndex] = nums[readIndex]
            if (readIndex > writeIndex) nums[readIndex] = 0
            writeIndex++
        }
    }
}
