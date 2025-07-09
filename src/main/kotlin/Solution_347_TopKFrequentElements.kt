/**
 * 347  Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 */
fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2
    println(topKFrequent(nums, k).contentToString())
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    return mutableMapOf<Int, Int>()
        .apply {
            // добавляем в map каждое число из nums, подсчитывая их количество
            // key - num, value - count
            nums.forEach { num ->
                compute(num) { _, count -> (count ?: 0) + 1 }
            }
        }.let { map ->
            map.entries // берем все пары ключ - значение MutableMap.MutableEntry<Int, Int>
                .sortedByDescending { it.value } // сортируем по убыванию значений
                .take(k) //  берем первые k элементов
                .map { it.key } // преобразовываем в список только ключей (nums)
                .toIntArray()
        }
}