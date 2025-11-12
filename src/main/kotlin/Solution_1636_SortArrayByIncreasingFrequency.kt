/**
 * 1636 Sort Array by Increasing Frequency
 *
 * Easy
 *
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 *
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
fun main() {
    val nums = intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1)
    println(frequencySort(nums).contentToString())
}

/**
 * Объяснение решения:
 *
 * Подсчет частоты: Создаем словарь frequency, где ключ - число, значение - сколько раз оно встречается в массиве.
 *
 * Сортировка по правилам:
 *
 * Основное правило: Сортируем по возрастанию частоты (чем реже число встречается, тем раньше оно должно быть в результате)
 *
 * Второстепенное правило: Если частоты одинаковы, сортируем по убыванию значения (большие числа идут перед меньшими)
 */
fun frequencySort(nums: IntArray): IntArray {
    // создаем словарь frequency, где ключ - число, значение - сколько раз оно встречается в массиве.
    val frequency = mutableMapOf<Int, Int>()

    // считаем количество вхождений каждого числа
    nums.forEach {
        frequency.merge(it, 1, Int::plus)
    }

    // компаратор вначале сравнивает количество вхождений каждого числа по возрастанию
    // если количество одинаковое, то сравниваются числа в обратном порядке для сортировки по убыванию
    val comparator = Comparator<Int> { a, b ->
        val freqA = frequency[a]!!
        val freqB = frequency[b]!!
        val res = freqA.compareTo(freqB)
        if (res == 0) b.compareTo(a) else res
    }

    // сортируем массив с этим компаратором
    return nums.sortedWith(comparator).toIntArray()
}

fun frequencySort2(nums: IntArray): IntArray {
    return nums.map { v -> v to nums.count { it == v } }
        .sortedBy { -it.first }
        .sortedBy { it.second }
        .map { it.first }
        .toIntArray()
}