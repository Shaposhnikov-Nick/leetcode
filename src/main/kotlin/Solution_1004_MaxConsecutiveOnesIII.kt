/**
 * 1004 Max Consecutive Ones III
 *
 * Medium
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
fun main() {
    val nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0)
    val k = 2
    println(longestOnes(nums, k))
}

/**
 * Идея алгоритма: Мы используем технику sliding window (скользящее окно), где:
 *
 * left и right обозначают границы текущего окна
 *
 * Мы расширяем окно, двигая right вправо
 *
 * Если количество нулей в окне превышает k, мы сужаем окно, двигая left вправо
 *
 * Переменные:
 *
 * zeroCount - количество нулей в текущем окне
 *
 * maxLength - максимальная длина валидного окна (последовательности)
 *
 * Процесс:
 *
 * Для каждого элемента массива (двигаем right):
 *
 * Если текущий элемент 0, увеличиваем zeroCount
 *
 * Пока zeroCount > k, двигаем left и уменьшаем zeroCount, если уходим от нуля
 *
 * Обновляем maxLength если текущее окно больше предыдущего максимума
 */
fun longestOnes(nums: IntArray, k: Int): Int {
    var left = 0
    var maxLength = 0
    var zeroCount = 0


    for (right in nums.indices) {
        if (nums[right] == 0) zeroCount++

        // Если количество нулей превысило k, двигаем левую границу
        while (zeroCount > k) {
            if (nums[left] == 0) zeroCount--
            left++
        }

        // Обновляем максимальную длину
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}