import java.math.BigDecimal

/**
 * 217 Contains Duplicate
 *
 * Easy
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: true
 *
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: false
 *
 * Explanation:
 *
 * All elements are distinct.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
fun main() {
    val nums = intArrayOf(1, 2, 3, 1)
    containsDuplicate(nums)
}

/**
 * Добавляем каждое число в Set, и если число уже там есть, возвращаем true
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val seen = mutableSetOf<Int>()

    nums.forEach {
        if (!seen.add(it)) return true
    }

    return false
}

/**
 * Сохраяем каждое число из массива в HashMap
 * Если чсило уже было в HashMap, значит это дубликат, возвращаем true
 */
fun containsDuplicate2(nums: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()

    for (num in nums) {
        val count = map[num]
        if (count != null) return true
        map[num] = 1
    }

    return false
}