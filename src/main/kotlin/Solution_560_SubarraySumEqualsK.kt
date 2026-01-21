/**
 * 560 Subarray Sum Equals K
 *
 * Medium
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
fun main() {
    val nums = intArrayOf(1, 1, 1)
    val k = 2
    subarraySum(nums, k)
}

/**
 * Объяснение алгоритма:
 *
 * Основная идея: Используем префиксные суммы. Если сумма элементов от индекса i до j равна k, то:
 *
 * text
 * prefixSum[j] - prefixSum[i-1] = k
 * Где prefixSum[x] - сумма элементов от начала массива до индекса x.
 *
 * Переформулировка: Мы ищем такие индексы i и j, где:
 *
 * text
 * prefixSum[j] - prefixSum[i] = k
 * или:
 *
 * text
 * prefixSum[j] - k = prefixSum[i]
 * Алгоритм:
 *
 * Проходим по массиву, накапливая текущую сумму currentSum
 *
 * Для каждого элемента проверяем, встречалась ли ранее префиксная сумма currentSum - k
 *
 * Если да, то увеличиваем счетчик на частоту этой префиксной суммы
 *
 * Обновляем частоту текущей префиксной суммы в хэш-таблице
 *
 * Пример:
 * Для nums = [1,1,1], k = 2:
 *
 * Шаг 0: currentSum = 0, map = {0:1}
 *
 * Шаг 1: currentSum = 1, ищем 1-2=-1 (0), map = {0:1, 1:1}
 *
 * Шаг 2: currentSum = 2, ищем 2-2=0 (нашли 1), count=1, map = {0:1, 1:1, 2:1}
 *
 * Шаг 3: currentSum = 3, ищем 3-2=1 (нашли 1), count=2, map = {0:1, 1:1, 2:1, 3:1}
 *
 * Сложность:
 *
 * Время: O(n), где n - длина массива
 *
 * Память: O(n) в худшем случае для хранения префиксных сумм
 */
fun subarraySum(nums: IntArray, k: Int): Int {
    // Хэш-таблица для хранения частот префиксных сумм
    val prefixSumCount = mutableMapOf<Int, Int>()
    // Инициализируем с нулевой префиксной суммой (уже встретили 1 раз)
    prefixSumCount[0] = 1
    var currentSum = 0
    var count = 0

    for (num in nums) {
        currentSum += num
        // Если (currentSum - k) существует в map, значит есть подмассив с суммой k
        count += prefixSumCount.getOrDefault(currentSum - k, 0)
        // Обновляем количество текущей префиксной суммы
        prefixSumCount[currentSum] = prefixSumCount.getOrDefault(currentSum, 0) + 1
    }

    return count
}

fun subarraySum2(nums: IntArray, k: Int): Int {
    val prefix = IntArray(nums.size)
    val map = HashMap<Int, Int>()
    var ps = 0
    var count = 0
    for (i in 0 until nums.size) {
        ps += nums[i]
        prefix[i] = ps
    }

    for (i in 0 until nums.size) {
        if (prefix[i] == k) count++
        val target = prefix[i] - k
        count += map[target] ?: 0
        map[prefix[i]] = (map[prefix[i]] ?: 0) + 1
    }
    return count
}