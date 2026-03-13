fun main() {
    val image = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    val sr = 1 // индекс строки
    val sc = 1 // индекс ячейки в строке
    val color = 2
    floodFill(image, sr, sc, color)
}

/**
 * Алгоритм решения
 *
 * Решение основано на обходе смежных элементов. Обычно применяется рекурсивный DFS или итеративный BFS:
 *
 * Запоминается исходный цвет стартовой точки.
 *
 * Выполняется обход по соседям, совпадающим по цвету.
 *
 * Каждый посещённый пиксель перекрашивается в новый цвет.
 *
 * Обход продолжается, пока не достигнуты все смежные пиксели исходного цвета.
 */
fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    // Запоминается исходный цвет стартовой точки.
    val startColor = image[sr][sc]
    if (startColor == color) return image
    // вызываем функцию для первой заданной точки
    dfs(image, sr, sc, color, startColor)
    // возвращаем измененный массив
    return image
}

fun dfs(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int, startColor: Int) {
    // проверяем что мы не вышли за границы массива
    // sr < 0 - номер строки не меньше нуля
    // sc < 0 - номер столбцы не меньше 0
    // sr >= image.size     - номер строки не больше количеества всех строк в массиве
    // sc >= image[sr].size - номер столбца не больше колиества столбцов в строке
    if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[sr].size) return

    // проверяем что цвет в ячейке совпадает с стартовым
    if (image[sr][sc] != startColor) return

    // меняем цвет в ячейке на новый
    image[sr][sc] = newColor

    // вызываем рекурсивно эту функцию для соседних клеток
    // клетка вверх
    dfs(image, sr - 1, sc, newColor, startColor)

    // клетка вниз
    dfs(image, sr + 1, sc, newColor, startColor)

    // клетка влево
    dfs(image, sr, sc - 1, newColor, startColor)

    // клетка вправо
    dfs(image, sr, sc + 1, newColor, startColor)
}

