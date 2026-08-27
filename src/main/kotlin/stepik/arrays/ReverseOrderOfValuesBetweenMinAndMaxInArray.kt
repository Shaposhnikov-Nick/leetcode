package stepik.arrays

import kotlin.math.max
import kotlin.math.min

/**
 * 3.2 Массивы
 *
 * Дан массив целых чисел. Преобразовать исходный массив, переставляя в обратном порядке элементы между максимальным
 * и минимальным значениями массива, включая их.
 *
 * Формат входных данных
 *
 * Исходные данные являются целыми числами в диапазоне от от −10 6 до 10 6
 *
 * Формат выходных данных
 *
 * Выведите преобразованный массив. Все элементы должны быть выведены в одной строке и разделяться одним пробелом.
 *
 * Тестовые данные
 *
 * Входные данные
 *
 * 12 -30 23 43 1 -3 18 -25 44 31 -28 54 4 14 6 -40 12 -10 -23 21
 *
 * 12 -30 23 43 1 -3 18 -25 44 31 -28 -40 6
 */
fun main() {
    val nums = readln().split(" ").map { it.toLong() }.toMutableList()
//    val nums = arrayOf(12, -30, 23, 43, 1, -3, 18, -25, 44, 31, -28, 54, 4, 14, 6, -40, 12, -10, -23, 21)

    var minValueIndex = 0
    var minValue = nums[0]
    var maxValueIndex = 0
    var maxValue = nums[0]

    for (i in nums.indices) {
        if (nums[i] > maxValue) {
            maxValue = nums[i]
            maxValueIndex = i
        }
        if (nums[i] < minValue) {
            minValue = nums[i]
            minValueIndex = i
        }
    }

    var left = min(minValueIndex, maxValueIndex)
    var right = max(minValueIndex, maxValueIndex)

    while (left < right) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        left++
        right--
    }

    print(nums.joinToString(" "))
}