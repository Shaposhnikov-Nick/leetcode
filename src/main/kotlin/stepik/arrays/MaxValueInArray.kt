package stepik.arrays

/**
 * Поиск максимального значения в массиве
 */
fun main() {
    val n = readln()
    val values = readln().split(" ").map { it.toInt() }
    var max = values[0]
    for (i in values) {
        if(i > max) max = i
    }
    println(max)
}