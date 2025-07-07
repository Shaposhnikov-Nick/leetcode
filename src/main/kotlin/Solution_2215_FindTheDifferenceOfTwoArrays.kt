/**
 * 2215 Find the Difference of Two Arrays
 *
 * Easy
 *
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
 *
 * Example 2:
 *
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */
fun main() {
    val nums1 = intArrayOf(1, 2, 3, 3)
    val nums2 = intArrayOf(1, 1, 2, 2)
    println(findDifference(nums1, nums2))
}

/**
 * Используем HashMap
 */
fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val nums1result = mutableSetOf<Int>()
    val nums2result = mutableSetOf<Int>()
    val nums1Map = mutableMapOf<Int, Int>()
    val nums2Map = mutableMapOf<Int, Int>()

    // добавляем каждое число в свою Map
    nums1.forEach { nums1Map[it] = it }
    nums2.forEach { nums2Map[it] = it }

    // проверяем, есть ли число из текущего массива в мапе другого массива
    nums1.forEach { if (nums2Map[it] == null) nums1result.add(it) }
    nums2.forEach { if (nums1Map[it] == null) nums2result.add(it) }

    // возвращаем результат
    result.addAll(listOf(nums1result.toList()))
    result.addAll(listOf(nums2result.toList()))

    return result
}

fun findDifference2(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val set1 = nums1.toSet()
    val set2 = nums2.toSet()
    return listOf(set1.subtract(set2).toList(), set2.subtract(set1).toList())
}
