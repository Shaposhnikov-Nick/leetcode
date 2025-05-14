package stepik.arrays

/**
 * Найдите второе по величине число в массиве чисел. Максимальное число в массиве встречается единожды.
 */
fun main() {
    val n = readln()
    val values = readln().split(" ").map { it.toInt() }
    var max = values[0]
    var secondMax = values[0]

    for (i in 1..<values.size) {
        if (values[i] > max) {
            secondMax = max
            max = values[i]
            continue
        }
        if (values[i] > secondMax) secondMax = values[i]
    }
    println(secondMax)
}