/**
 * 189 Rotate Array
 *
 * Medium
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val k = 3
    rotate(nums, k)
}

fun rotate(nums: IntArray, k: Int): Unit {
    val n = nums.size
    // Если k больше длины, берём по модулю
    val steps = k % n
    if (steps == 0) return

    // Вспомогательная функция для переворота подмассива [start..end]
    fun reverse(start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            i++; j--
        }
    }

    // 1) Переворачиваем весь массив
    reverse(0, n - 1)
    // 2) Переворачиваем первые steps элементов
    reverse(0, steps - 1)
    // 3) Переворачиваем оставшиеся
    reverse(steps, n - 1)
}