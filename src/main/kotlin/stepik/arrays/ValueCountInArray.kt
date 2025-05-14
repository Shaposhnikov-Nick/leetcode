package stepik.arrays

/**
 * Подсчет, сколько раз искомое число встречается в массиве
 */
fun main() {
    val n = readln()
    val values = readln().split(" ").map { it.toInt() }
    val target = readln().toInt()
    println(values.count { it == target })
}