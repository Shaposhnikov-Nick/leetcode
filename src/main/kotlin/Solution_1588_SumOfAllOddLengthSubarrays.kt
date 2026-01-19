/**
 * 1588 Sum of All Odd Length Subarrays
 *
 * Easy
 *
 * Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: 3
 * Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
 * Example 3:
 *
 * Input: arr = [10,11,12]
 * Output: 66
 */
fun main() {
    val arr = intArrayOf(1, 4, 2, 5, 3)
    sumOddLengthSubarrays(arr)
}

/**
 * Краткая логика решения:
 *
 * Суть метода:
 *
 * Вместо того чтобы каждый раз заново суммировать элементы подмассива, мы заранее вычисляем и запоминаем все промежуточные суммы.
 *
 * Как это работает:
 * Создаем "шпаргалку" сумм:
 *
 * Делаем массив, где на i-й позиции хранится сумма первых i элементов
 *
 * Например, если массив [1, 4, 2], то шпаргалка: [0, 1, 5, 7]
 *
 * Это суммы: 0 элементов = 0, 1 элемент = 1, 2 элемента = 5, 3 элемента = 7
 *
 * Быстро вычисляем сумму любого подмассива:
 *
 * Нужна сумма от позиции start до end?
 *
 * Смотрим в шпаргалке сумму до end+1 (все элементы до end включительно)
 *
 * Вычитаем сумму до start (все элементы перед start)
 *
 * Остается сумма именно нужного нам подмассива
 *
 * Аналогия:
 * Представьте, что у вас есть весы с гирями:
 *
 * prefixSum[3] = вес гирь 1, 2 и 3
 *
 * prefixSum[1] = вес только гири 1
 *
 * prefixSum[3] - prefixSum[1] = вес гирь 2 и 3 (то, что между ними)
 *
 * Итоговый алгоритм:
 * Посчитали шпаргалку сумм
 *
 * Перебираем все возможные подмассивы
 *
 * Если длина нечетная → быстро вычисляем сумму по шпаргалке
 *
 * Добавляем к общему результату
 */
fun sumOddLengthSubarrays(arr: IntArray): Int {
    val n = arr.size
    val prefixSum = IntArray(n + 1)
    var totalSum = 0

    /**
     * Вычисляем префиксные суммы для каждого числа в массиве arr
     *
     * Префиксная сумма (prefix sum) — это массив, где prefixSum[i] содержит сумму первых i элементов исходного массива.
     *
     * Для массива arr = [1, 4, 2, 5, 3]:
     *
     * prefixSum[0] = 0 (сумма 0 элементов)
     *
     * prefixSum[1] = arr[0] = 1
     *
     * prefixSum[2] = arr[0] + arr[1] = 1 + 4 = 5
     *
     * prefixSum[3] = 1 + 4 + 2 = 7
     *
     * prefixSum[4] = 1 + 4 + 2 + 5 = 12
     *
     * prefixSum[5] = 1 + 4 + 2 + 5 + 3 = 15
     */
    for (i in 0..<n) {
        prefixSum[i + 1] = prefixSum[i] + arr[i]
    }

    /**
     * Перебираем все возможные начала (start) и концы (end) подмассивов
     */
    for (start in 0..<n) { // начало подмассива
        for (end in start..<n) {  // конец подмассива
            val length = end - start + 1 // длина подмассива
            // Проверяем, нечетная ли длина
            if (length % 2 == 1) {
                // Вычисляем сумму подмассива от start до end
                // Используем префиксные суммы для быстрого вычисления суммы подмассива
                // prefixSum[end + 1] = сумма всех элементов от arr[0] до arr[end] (включительно)
                // prefixSum[start] = сумма всех элементов от arr[0] до arr[start - 1]
                // Когда мы вычитаем из первого второе, остаются только элементы от arr[start] до arr[end].
                totalSum += prefixSum[end + 1] - prefixSum[start]
            }
        }
    }

    return totalSum
}