/**
 * 1122 Relative Sort Array
 *
 * Easy
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * Example 2:
 *
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 *
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 */
fun main() {
    val arr1 = intArrayOf(2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31)
    val arr2 = intArrayOf(2, 42, 38, 0, 43, 21)
    relativeSortArray(arr1, arr2)
}

/**
 * Проходим по массиву arr1 и подсчитывем количество вхождений каждого числа
 * Затем проходим по массиву arr2 и для каждого его значения записываем в массив result это значение определенное количество раз
 * при это удаляем это число из freqMap
 * После оставшиеся в freqMap значения сортируем в порядке возрастания и аналогичным способом записываем в result
 */
fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val result = IntArray(arr1.size)
    val freqMap = HashMap<Int, Int>()

    // Проходим по массиву arr1 и подсчитывем количество вхождений каждого числа
    for (num in arr1) {
        freqMap.merge(num, 1) { oldValue, newValue -> oldValue + newValue }
    }

    // Затем проходим по массиву arr2 и для каждого его значения записываем в массив result это значение определенное количество раз
    var i = 0
    var j = 0
    for (num in arr2) {
        val count = freqMap[num]!!

        while (j < i + count) {
            result[j] = num
            j++
        }

        // при этом удаляем это число из freqMap
        freqMap.remove(num)
        i = j
    }

    // После оставшиеся в freqMap значения сортируем в порядке возрастания и аналогичным способом записываем в result
    freqMap.entries.sortedBy { it.key }.forEach { (num, count) ->
        while (j < i + count) {
            result[j] = num
            j++
        }
        i = j
    }

    return result
}

