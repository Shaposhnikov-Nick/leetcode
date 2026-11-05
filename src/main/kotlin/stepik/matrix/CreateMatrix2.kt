package stepik.matrix

/**
 * * 3.3 Многомерные массивы и матрицы
 *
 * Заполнение змейкой
 * Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).
 *
 * Входные данные
 *
 * Программа получает на вход два числа n и m. Числа по модулю не превышают 2^31 −1.
 *
 * Выходные данные
 *
 * Программа должна вывести  полученный массив, отводя на вывод каждого числа ровно 3 символа с выравниванием по правой стороне.
 */

/**
 * Создаем матрицу, для каждой строки в ней выбираем последовательность индексов либо сначала либо с конца
 * и заполняем значения. Т.к. число должно заниамть 3 символа. недостающие заполняем пробелами.
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val matrix = Array(n) { Array(m) { "" } }
    var value = 0

    matrix.forEachIndexed { index, row ->
        val range = if (index % 2 == 0) row.indices else row.indices.reversed()
        for (i in range) {
            var str = value.toString()
            val shift = 3 - str.length
            if (shift != 0) {
                str = buildString {
                    repeat(shift) {
                        insert(0, " ")
                    }
                    append(str)
                }
            }
            row[i] = str
            value++
        }

        println(row.joinToString(separator = " "))
    }
}