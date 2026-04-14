/**
 * 228 Summary Ranges
 *
 * Easy
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
fun main() {
    val nums = intArrayOf(0, 1, 2, 4, 5, 7)
    summaryRanges(nums)
}

/**
 * Используем 2 указателя
 * Указатель l обозначает начало диапазона, указатель r - конец диапазона
 * Двигаем r вправо, пока сохраняется условие, что каждое следующее число больше предыдущего на 1
 * Если диапазон более одного числа, создаем строку с этим диапазоном
 * Если в диапазоне одно число, добавляем его
 * Ставим оба указателя на следующую ячейку за этим диапазоном
 */
fun summaryRanges(nums: IntArray): List<String> {
    val ranges = mutableListOf<String>()

    // Используем 2 указателя
    // Указатель l обозначает начало диапазона, указатель r - конец диапазона
    var l = 0
    var r = 0

    while (r < nums.size) {
        // Двигаем r вправо, пока сохраняется условие, что каждое следующее число больше предыдущего на 1
        while (r < nums.size - 1 && nums[r + 1] - nums[r] == 1) {
            r++
        }

        // Если диапазон более одного числа, создаем строку с этим диапазоном
        val range = if (r > l) "${nums[l]}->${nums[r]}"
        // Если в диапазоне одно число, добавляем его
        else nums[l].toString()

        ranges.add(range)

        // Ставим оба указателя на следующую ячейку за этим диапазоном
        r++
        l = r
    }

    return ranges
}