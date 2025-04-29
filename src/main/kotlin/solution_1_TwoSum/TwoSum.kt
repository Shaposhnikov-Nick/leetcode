package ru.leetcode.solution_1_TwoSum


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