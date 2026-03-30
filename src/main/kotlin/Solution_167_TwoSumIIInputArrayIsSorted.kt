/**
 * 167. Two Sum II - Input Array Is Sorted
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */
fun main() {
    val numbers = intArrayOf(2, 7, 11, 15)
    val target = 9
    twoSumII(numbers, target)
}

/**
 * Т.к. массив заранее отсортирован, берем каждое его значение с начала и с помощью бинарного поиска
 * ищем подходящее значение справа
 */
fun twoSumII(numbers: IntArray, target: Int): IntArray {
    // Для каждого значения в массиве ищем подходящее число справа
    for (i in numbers.indices) {
        val firstValue = numbers[i]
        // Число, которое нужно найти
        val searchValue = target - firstValue
        // Индекс искомого числа если оно есть либо null
        val searchValueIndex = binarySearch(numbers, i + 1, numbers.size - 1, searchValue)
        if (searchValueIndex != null) return intArrayOf(i + 1, searchValueIndex + 1)
    }

    return intArrayOf()
}

fun binarySearch(numbers: IntArray, startIndex: Int, endIndex: Int, searchValue: Int): Int? {
    // если левый индекс обогнал правый - выход
    if (startIndex > endIndex) return null

    // если левый индекс совпал с правым проверяем его значение
    if (startIndex == endIndex) {
        return if (numbers[startIndex] == searchValue) startIndex
        else null
    }

    // ищем середину и проверяем значение по этому индексу
    val midIndex = startIndex + (endIndex - startIndex) / 2
    val midIndexValue = numbers[midIndex]
    if (midIndexValue == searchValue) return midIndex

    // если значение середины не соответствует searchValue то
    return if (searchValue < midIndexValue)
    // если искомое значение меньше значения середины, ищем в левом подмассиве
        binarySearch(numbers, startIndex, midIndex - 1, searchValue)
    else
    // если искомое значение больше значения середины, ищем в правом подмассиве
        binarySearch(numbers, midIndex + 1, endIndex, searchValue)
}