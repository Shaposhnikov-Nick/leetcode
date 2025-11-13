/**
 * 2404 Most Frequent Even Element
 *
 * Easy
 *
 * Given an integer array nums, return the most frequent even element.
 *
 * If there is a tie, return the smallest one. If there is no such element, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,2,4,4,1]
 * Output: 2
 * Explanation:
 * The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 * We return the smallest one, which is 2.
 * Example 2:
 *
 * Input: nums = [4,4,4,9,2,4]
 * Output: 4
 * Explanation: 4 is the even element appears the most.
 * Example 3:
 *
 * Input: nums = [29,47,21,41,13,37,25,7]
 * Output: -1
 * Explanation: There is no even element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 105
 */
fun main() {
    val nums = intArrayOf(0, 1, 2, 2, 4, 4, 1)
    println(mostFrequentEven(nums))
}

fun mostFrequentEven(nums: IntArray): Int {
    return nums
        .filter { it % 2 == 0 }                      // Фильтруем только четные числа
        .groupBy { it }                              // Группируем по значению
        .mapValues { it.value.size }                 // Преобразуем в карту "число -> частота"
        .let { frequencyMap ->
            if (frequencyMap.isEmpty()) return -1    // Нет четных чисел
            else {
                val maxFrequency = frequencyMap.values.max()   // Находим максимальную частоту
                frequencyMap.filter { it.value == maxFrequency }.keys.min()  // Берем все числа с максимальной частотой и выбираем наименьшее
            }
        }
}