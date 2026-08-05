/**
 * 2389 Longest Subsequence With Limited Sum
 *
 * Easy
 *
 * You are given an integer array nums of length n, and an integer array queries of length m.
 *
 * Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,2,1], queries = [3,10,21]
 * Output: [2,3,4]
 * Explanation: We answer the queries as follows:
 * - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
 * - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
 * - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
 * Example 2:
 *
 * Input: nums = [2,3,4,5], queries = [1]
 * Output: [0]
 * Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 106
 */
fun main() {
    val nums = intArrayOf(4, 5, 2, 1)
    val queries = intArrayOf(3, 10, 21)
    answerQueries(nums, queries)
}

/**
 * Сортируем nums
 * Считаем префиксные суммы для nums
 * После этого для каждого query находим индекс префиксной суммы, которая меньше либо равна query (используем бинарный поиск)
 */
fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    val prefixSum = ArrayList<Int>()
    val answer = IntArray(queries.size)

    nums.sort()
    prefixSum.add(nums[0])

    // Считаем префиксные суммы для nums
    for (index in 1 until nums.size) {
        prefixSum.add(nums[index] + prefixSum[index - 1])
    }

    // для каждого query находим индекс префиксной суммы, которая меньше либо равна query
    // используем бинарный поиск
    queries.forEachIndexed { index, query ->
        answer[index] = search(prefixSum, target = query)
    }

    return answer
}

fun search(prefixSum: ArrayList<Int>, target: Int): Int {
    var left = 0
    var right = prefixSum.size

    while (right > left) {
        val mid = (left + right) / 2
        if (prefixSum[mid] < target + 1) left = mid + 1
        else right = mid
    }

    return left
}