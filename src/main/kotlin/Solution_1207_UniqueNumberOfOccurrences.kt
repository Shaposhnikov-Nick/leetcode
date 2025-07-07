/**
 * 1207 Unique Number of Occurrences
 *
 * Easy
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 *
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 *
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 */
fun main() {
    val arr = intArrayOf(1, 2, 2, 1, 1, 3, 2)
    println(uniqueOccurrences(arr))
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()

    // добавляем в Map каждое число из массива и подсчитываем их количество
    // num - ключ, количество вхождений - значение
    arr.forEach { num ->
        map.compute(num) { _, count -> (count ?: 0) + 1 }
    }

    // преобразовываем в Set, чтобы оставит только уникальные значения
    val unique = map.values.toSet()

    // сравниваем количество значений в Map и в unique
    return map.size == unique.size
}