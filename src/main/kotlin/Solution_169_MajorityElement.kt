/**
 * 169. Majority Element
 *
 * Easy
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 * always exists in the array.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
fun main() {
    val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
    println(majorityElement(nums))
}

/**
 * Используем hashmap для подсчета количества каждого числа в массиве.
 * Возвращаем число, которое встретилось чаще чем nums.size / 2
 */
fun majorityElement(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    // считаем количество вхождений каждого числа
    nums.forEach { num -> map.merge(num, 1, Int::plus) }
    val target = nums.size / 2

    return map.entries.first { it.value > target }.key
}

/**
 * Время: O(n)
 * Память: O(1)
 * Алгоритм Бойера-Мура для поиска большинства (Boyer-Moore Majority Vote Algorithm)
 */
fun majorityElement2(nums: IntArray): Int {
    var candidate = nums[0]
    var count = 0

    nums.forEach { num ->
        if (num == candidate) count++
        else {
            count--
            if (count == 0) {
                candidate = num
                count = 1
            }
        }
    }
    return candidate
}