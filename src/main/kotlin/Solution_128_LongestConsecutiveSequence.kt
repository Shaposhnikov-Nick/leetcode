import kotlin.math.max

/**
 * 128  Longest Consecutive Sequence
 *
 * Medium
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 */
fun main() {
    val nums = intArrayOf(100, 4, 200, 1, 3, 2)
    longestConsecutive(nums)
}

/**
 * 1. Преобразование массива в множество (HashSet):
 *
 * Это позволяет осуществлять проверки наличия элементов за O(1) времени.
 *
 * 2. Итерация по элементам множества:
 *
 * Для каждого числа проверяем, является ли оно началом последовательности (т.е. отсутствует ли предыдущее число num - 1 в множестве).
 *
 * 3. Поиск последовательности:
 *
 * Если число является началом последовательности, то увеличиваем текущее число и счетчик последовательности до тех пор, пока следующие числа присутствуют в множестве.
 *
 * 4. Обновление максимальной длины:
 *
 * После нахождения каждой последовательности сравниваем её длину с текущей максимальной и обновляем последнюю при необходимости.
 */
fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toHashSet()
    var longest = 0

    for (num in numSet) {
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentLongest = 1

            while (numSet.contains(currentNum + 1)) {
                currentNum++
                currentLongest++
            }
            longest = max(longest, currentLongest)
        }
    }

    return longest
}