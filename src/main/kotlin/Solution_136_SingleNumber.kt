/**
 * 136 Single Number
 *
 * Easy
 * -empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 *
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [1]
 *
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
fun main() {
    val nums = intArrayOf(4, 1, 2, 1, 2)
    singleNumber(nums)
}

/**
 * Суть алгоритма:
 *
 * Алгоритм находит элемент, который встречается в массиве нечетное количество раз, при условии что все остальные элементы встречаются четное количество раз (обычно 2 раза).
 *
 * Ключевые свойства XOR, которые использует алгоритм:
 * a xor a = 0 - одинаковые числа "уничтожают" друг друга
 *
 * a xor 0 = a - XOR с нулём оставляет число неизменным
 *
 * a xor b xor a = b - коммутативность и ассоциативность
 */
fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (num in nums) {
        result = result xor num
    }

    return result
}