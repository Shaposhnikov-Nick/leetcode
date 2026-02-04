/**
 * 118 Pascal's Triangle
 *
 * Easy
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
fun main() {
    val numRows = 5
    generate(numRows)
}

/**
 * Алгоритм:
 *
 * Начинаем с первой строки: [1].
 *
 * Для каждой новой строки i:
 *
 * Создаем массив длины i+1.
 *
 * Первый и последний элемент = 1.
 *
 * Каждый внутренний элемент j = сумме j-1-го и j-го элементов предыдущей строки.
 *
 * Добавляем строку к результату.
 */
fun generate(numRows: Int): List<List<Int>> {
    // результирующий треугольник
    val triangle = mutableListOf<List<Int>>()
    // добавляем первую строку (вершину)
    triangle.add(listOf(1))

    // добавляем следующие строки
    for (i in 1 until numRows) {
        // создаем новую строку и заполняем ее единицами
        val row = MutableList(i + 1) { 1 }
        // берем из треугольника предыдущую строку
        val prevRow = triangle[i - 1]

        // заполняем новую строку суммой значений из предыдущей строки
        // кроме первого и последнего элемента, они остаются 1
        for (j in 1 until i) {
            row[j] = prevRow[j - 1] + prevRow[j]
        }

        // добавляем новую строку в треугольник
        triangle.add(row)
    }

    return triangle
}