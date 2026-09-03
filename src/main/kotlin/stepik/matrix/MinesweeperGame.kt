package stepik.matrix

import kotlin.math.min

/**
 * 3.3 Многомерные массивы и матрицы
 *
 * Напишите программу, отображающую игровое поле для игры "Сапер".
 *
 * Входные данные
 *
 * Даны числа N и M (целые, положительные, не превышают 32) – количество строк и столбцов в поле соответственно, далее число
 * W (целое, неотрицательное, не больше 1000) – количество мин на поле, далее следует  W пар чисел, координаты мины на поле
 * (первое число – строка, второе число – столбец). Числа по модулю не превышают 2 в 9 −1.
 *
 * Выходные данные
 *
 * Требуется вывести на экран поле. Формат вывода указан в примере.
 *
 *  * 0 0 0 1
 *  * 0 0 1 2
 *  * 0 1 2 2
 *  * 1 2 2 2
 */
fun main() {
//    val (m, n) = readln().split(" ").map { it.toInt() }
//    val matrix = Array(n) { Array(m) { "0" } }

//    val w = readln().toInt()

//    val coordinates = mutableListOf<Pair<Int, Int>>()
//    repeat(w) {
//        val (x, y) = readln().split(" ").map { it.toInt() }
//        coordinates.add(x to y)
//    }

    val m = 2
    val n = 3
    val w = 2
    val matrix = Array(n) { Array(m) { "0" } }
    val coordinates = mutableListOf<Pair<Int, Int>>(1 to 1, 2 to 2)


    coordinates.forEach { mine ->
        val row = mine.first - 1
        val col = mine.second - 1
        matrix[row][col] = "*"

        // верхняя клетка
        if (row > 0) {
            val value = matrix[row - 1][col]
            if (value != "*") matrix[row - 1][col] = (value.toInt() + 1).toString()
        }
        // нижняя клетка
        if (row < n - 1) {
            val value = matrix[row + 1][col]
            if (value != "*") matrix[row + 1][col] = (value.toInt() + 1).toString()
        }
        // левая клетка
        if (col > 0) {
            val value = matrix[row][col - 1]
            if (value != "*") matrix[row][col - 1] = (value.toInt() + 1).toString()
        }
        // правая клетка
        if (col < m - 1) {
            val value = matrix[row][col + 1]
            if (value != "*") matrix[row][col + 1] = (value.toInt() + 1).toString()
        }
        // верхняя левая клетка
        if (row > 0 && col > 0) {
            val value = matrix[row - 1][col - 1]
            if (value != "*") matrix[row - 1][col - 1] = (value.toInt() + 1).toString()
        }
        // нижняя левая клетка
        if (row < n - 1 && col > 0) {
            val value = matrix[row + 1][col - 1]
            if (value != "*") matrix[row + 1][col - 1] = (value.toInt() + 1).toString()
        }
        // верхняя правая клетка
        if (row > 0 && col < m - 1) {
            val value = matrix[row - 1][col + 1]
            if (value != "*") matrix[row - 1][col + 1] = (value.toInt() + 1).toString()
        }
        // нижняя правая клетка
        if (row < n - 1 && col < m - 1) {
            val value = matrix[row + 1][col + 1]
            if (value != "*") matrix[row + 1][col + 1] = (value.toInt() + 1).toString()
        }
    }

    for (i in matrix.indices) {
        val row = mutableListOf<String>()
        for (j in matrix[i].indices) {
            row.add(matrix[i][j])
        }
        println(row.joinToString(" "))
    }

}

