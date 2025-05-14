package stepik.arrays

/**
 * Вы получили набор чисел. Напишите программу, которая возвращает сумму всех чисел.
 *
 * Формат входных данных:
 *
 * Первая строка содержит число n
 *
 * На следующей строке находятся n целых чисел (1 ≤
 */
fun main() {
    val n = readln()
    val values = readln().split(" ").map { it.toInt() }
    println(values.fold(0) { a, b -> a + b })
}