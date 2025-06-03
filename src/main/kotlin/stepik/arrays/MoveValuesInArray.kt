package stepik.arrays

/**
 * У вас есть массив чисел и целое число k. Сдвиньте массив вправо на k шагов.
 *
 * Формат входных данных:
 * Первая строка содержит число n (1 ≤ n ≤ 10^5).
 *
 * На второй строке находятся n целых чисел (1 ≤ a ≤ 10^9), разделенных пробелами.
 *
 * Третья строка содержит целое число k (0 ≤ k < n).
 *
 * Формат выходных данных:
 * Полученный массив чисел, выведенный через пробел.
 *
 * Sample Input:
 *
 * 5
 * 1 2 3 4 5
 * 2
 * Sample Output:
 *
 * 4 5 1 2 3
 */
fun main() {
    val n = readln().toInt()
    val values = readln().split(" ").map { it.toInt() }.toIntArray()
    val k = readln().toInt()

    val newValues = IntArray(n)

    for (i in values.indices) {
        var newIndex = i + k
        if (newIndex > values.size - 1)
            newIndex -= values.size
        newValues[newIndex] = values[i]
    }

    for (i in newValues) {
        print("$i ")
    }
}