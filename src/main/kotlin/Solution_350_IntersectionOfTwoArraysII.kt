/**
 * 350 Intersection of Two Arrays II
 *
 * Easy
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
fun main() {
    val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(2, 2)
    intersect(nums1, nums2)
}

/**
 * Используем hashmap для хранения частот чисел в одном из массивов
 * Проходим по второму массиву и ищем в мапе такое же число.
 * Если число есть и его количество больше или равно 1,добавляем число в result и уменьшаем его количество на 1
 */
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    // Используем hashmap для хранения частот чисел в одном из массивов
    val map = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()

    // Считаем количество повторений каждого числа в первом массиве
    for (num in nums1) {
        map.merge(num, 1, Int::plus)
    }

    // Проходим по каждому числу второго массива и ищем его в мапе
    for (num in nums2) {
        val count = map[num]
        // если нашли, проверяем количество
        if (count != null && count >= 1) {
            // добавляем в ответ
            result.add(num)
            // уменьшаем счетчик числа
            map.merge(num, 1, Int::minus)
        }
    }

    return result.toIntArray()
}