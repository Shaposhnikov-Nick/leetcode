import java.util.ArrayDeque

/**
 * 503 Next Greater Element II
 *
 * Medium
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 3)
    nextGreaterElements(nums)
}

/**
 * Объяснение алгоритма:
 *
 * Идея: Используем монотонный убывающий стек для хранения индексов элементов, для которых мы еще не нашли следующий больший элемент.
 *
 * Ключевые моменты:
 *
 * Поскольку массив круговой, мы проходим по нему дважды (2 * n итераций)
 *
 * Используем оператор % для получения корректного индекса в исходном массиве
 *
 * Добавляем индексы в стек только при первом проходе (первые n элементов)
 *
 * Когда находим элемент больше элемента на вершине стека, обновляем результат для этого элемента
 *
 * Сложность:
 *
 * Время: O(n) - каждый элемент добавляется и удаляется из стека не более одного раза
 *
 * Память: O(n) - для стека и результирующего массива
 *
 * Работа алгоритма на примере [1, 2, 1]:
 *
 * Первый проход: обрабатываем [1, 2, 1]
 *
 * Второй проход: снова обрабатываем [1, 2, 1] для кругового поиска
 *
 * Результат: [2, -1, 2]
 */
fun nextGreaterElements(nums: IntArray): IntArray {
    val n = nums.size
    val stack = ArrayDeque<Int>()
    val result = IntArray(n) { -1 }

    // Проходим по массиву дважды для обработки кругового свойства
    for (i in 0 until n * 2) {
        val currentIndex = i % n
        val currentValue = nums[currentIndex]

        // Пока стек не пуст и текущий элемент больше элемента на вершине стека
        while (stack.isNotEmpty() && nums[stack.last()] < currentValue) {
            val prevIndex = stack.removeLast()
            result[prevIndex] = currentValue
        }

        // Добавляем индекс только при первом проходе
        if (i < n) {
            stack.addLast(currentIndex)
        }
    }

    return result
}