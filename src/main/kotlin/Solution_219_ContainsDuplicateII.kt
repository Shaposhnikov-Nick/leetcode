/**
 * 219 Contains Duplicate II
 *
 * Easy
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
fun main() {
    val nums = intArrayOf(1, 0, 1, 1)
    val k = 1
    containsNearbyDuplicate(nums, k)
}

/**
 * С использованием HashMap
 *
 * Алгоритм:
 *
 * Используем HashMap для хранения элементов и их последних индексов
 *
 * Проходим по массиву:
 *
 * Если элемент уже есть в HashMap, проверяем расстояние между текущим и предыдущим индексом
 *
 * Если расстояние ≤ k, возвращаем true
 *
 * Обновляем индекс текущего элемента в HashMap
 *
 * Если не нашли подходящей пары, возвращаем false
 */
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, Int>()

    // проходим по массиву
    for ((index, num) in nums.withIndex()) {
        // если map уже содержит пару цифра - индекс
        if (map.containsKey(num)) {
            // проверяем, что разница между индексами не более K
            val prevIndex = map[num]!!
            if (index - prevIndex <= k) return true
        }
        // если такой цифры еще не было, добавляем пару цифра - индекс в map
        map[num] = index
    }

    return false
}

/**
 * С использованием HashSet
 *
 * Это решение использует подход "скользящего окна" и поддерживает в Set только элементы из последних k позиций.
 */
fun containsNearbyDuplicate2(nums: IntArray, k: Int): Boolean {
    val set = mutableSetOf<Int>()

    for (i in nums.indices) {
        if (i > k) {
            set.remove(nums[i - k - 1])
        }
        if (!set.add(nums[i])) {
            return true
        }
    }

    return false
}

