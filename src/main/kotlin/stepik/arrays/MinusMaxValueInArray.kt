package stepik.arrays

/**
 * Дан массив чисел. Преобразовать исходный массив, вычитая максимальное значение массива из элементов массива, идущих после минимального.
 */
fun main() {
    val values = readln().split(" ").map { it.toInt() }.toIntArray()
    var maxValue = values[0]
    var minValue = values[0]
    var minValueIndex = 0

    for (i in values.indices) {
        if (values[i] > maxValue) maxValue = values[i]
        if (values[i] < minValue) {
            minValue = values[i]
            minValueIndex = i
        }
    }

    for (i in values.indices) {
        if (i > minValueIndex) println(values[i] - maxValue)
        else println(values[i])
    }
}