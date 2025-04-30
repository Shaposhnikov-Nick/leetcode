/**
 * 1 Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9,
 * Output: [0,1]
 *
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6,
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6,
 * Output: [0,1]
 */
fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = twoSum(nums, target)
    println(result.contentToString())
}

/**
 * O(n)
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val numsMap = HashMap<Int, Int>()

    for (i in nums.indices) {
        val find = target - nums[i]
        if (numsMap.containsKey(find)) {
            result[0] = numsMap[find]!!
            result[1] = i
            break
        }
        numsMap[nums[i]] = i
    }

    return result
}

/**
 * O(n2)
 */
fun twoSum2(nums: IntArray, target: Int): IntArray {
    val solution = IntArray(2)
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                solution[0] = i
                solution[1] = j
            }
        }
    }

    return solution
}