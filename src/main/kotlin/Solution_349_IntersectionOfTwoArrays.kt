/**
 * 349  Intersection of Two Arrays
 *
 * Easy
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
fun main() {
    val nums1 = intArrayOf(4, 9, 5)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)
    intersection(nums1, nums2)
}

/**
 * Поиск пересечений двух массивов
 * Преобразовываем первый массив в Set
 * Проверяем, совпадают ли элементы из второго массива. если совпадают, добавляем их в отдельный Set
 * Возвращаем преобразованный в массив Set
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val result = mutableSetOf<Int>()

    // Преобразовываем первый массив в Set
    val set = nums1.toSet()

    // Проверяем, совпадают ли элементы из второго массива
    for (num in nums2) {
        // если совпадают, добавляем их в отдельный Set
        if (num in set) result.add(num)
    }

    // Возвращаем преобразованный в массив Set
    return result.toIntArray()
}