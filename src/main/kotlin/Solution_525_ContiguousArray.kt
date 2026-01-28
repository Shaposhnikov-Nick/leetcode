/**
 * 525 Contiguous Array
 *
 * Medium
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
fun main() {
    val nums = intArrayOf(0, 1, 1, 1, 1, 1, 0, 0, 0)
    findMaxLength(nums)
}

/**
 * Идея:
 *
 * Заменяем 0 на -1, тогда задача сводится к поиску самой длинной подмассива с суммой 0.
 *
 * Используем переменную count, которая хранит текущую сумму (баланс).
 *
 * Если в какой-то момент count становится таким же, как на предыдущем индексе, значит между этими индексами сумма равна 0, т.е. количество 0 и 1 одинаково.
 *
 * Сохраняем в map первый индекс, на котором встречается определённое значение count.
 *
 * Если позже встречаем тот же count, вычисляем длину подмассива как разницу индексов.
 *
 * ---
 *
 * Объяснение работы:
 *
 * count изменяется: при 1 увеличивается на 1, при 0 уменьшается на 1.
 *
 * Если count встречался ранее, значит между предыдущим индексом и текущим сумма нулевая → количество 0 и 1 одинаково.
 *
 * Сохраняем максимальную длину таких отрезков.
 *
 * Сложность:
 *
 * Время: O(n)
 *
 * Память: O(n) (в худшем случае для хранения разных значений count).
 */
fun findMaxLength(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    map[0] = -1 // начальное состояние: сумма 0 на индексе -1

    var count = 0
    var maxLength = 0

    for (i in nums.indices) {
        // 0 -> -1, 1 -> +1
        count += if (nums[i] == 1) 1 else -1

        if (map.containsKey(count)) {
            maxLength = maxOf(maxLength, i - map[count]!!)
        } else {
            map[count] = i
        }
    }

    return maxLength
}