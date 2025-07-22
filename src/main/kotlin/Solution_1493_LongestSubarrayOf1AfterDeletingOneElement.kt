import kotlin.math.max

/**
 * 1493 Longest Subarray of 1's After Deleting One Element
 *
 * Medium
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 *
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
fun main() {
    val nums = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
    println(longestSubarray(nums))
}

/**
 * Объяснение:
 * Метод скользящего окна: Мы поддерживаем окно [left, right], которое содержит не более одного нуля. Это представляет
 * подмассив, где мы можем удалить один ноль, чтобы получить все 1.
 *
 * Подсчет нулей: При расширении окна (движение правой границы) мы считаем количество нулей в текущем окне. Если
 * встречаем более одного нуля, сужаем окно с левой границы, пока не останется не более одного нуля.
 *
 * Вычисление максимальной длины: Длина текущего валидного окна (right - left) дает нам длину подмассива после удаления
 * одного элемента (нуля). Мы отслеживаем максимальную такую длину.
 *
 * Обработка крайнего случая: Если весь массив состоит из 1, мы все равно должны удалить один элемент,
 * поэтому результат равен длине - 1.
 *
 * Сложность по времени и памяти:
 * Временная сложность: O(n) - каждый элемент обрабатывается ровно один раз обоими указателями.
 *
 * Пространственная сложность: O(1) - используется константное количество дополнительной памяти.
 */
fun longestSubarray(nums: IntArray): Int {
    var left = 0
    var zeroCount = 0
    var longest = 0

    for (right in nums.indices) {
        // Если текущий элемент равен 0, увеличиваем счетчик нулей
        if (nums[right] == 0) zeroCount++

        // Если в окне больше одного нуля, сдвигаем левую границу
        while (zeroCount > 1) {
            if (nums[left] == 0) zeroCount--
            left++
        }

        // Обновляем максимальную длину (длина окна минус один удаляемый элемент)
        longest = max(longest, right - left)
    }

    // Крайний случай: если все элементы равны 1, все равно нужно удалить один
    return if (longest == nums.size) nums.size - 1 else longest
}