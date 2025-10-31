/**
 * 35 Search Insert Position
 *
 * Easy
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 7
    println(searchInsert(nums, target))
}

/**
 * O(log n)
 * Бинарный поиск
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var lo = 0
    var hi = nums.size - 1

    while (lo <= hi) {
        val mid = (lo + hi) / 2
        if (nums[mid] < target) {
            lo = mid + 1
        } else {
            hi = mid - 1
        }
    }

    return lo
}

/**
 * O(n)
 *
 * Проверяем, что target между числом меньше его и больше или равного ему.
 * Иначе его позиция после последнего элемента.
 */
fun searchInsert2(nums: IntArray, target: Int): Int {
    if (target <= nums[0]) return 0
    for (i in 0 until nums.size - 1) {
        if (target > nums[i] && target <= nums[i + 1])
            return i + 1
    }
    return nums.size
}