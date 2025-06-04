/**
 * 977 Squares of a Sorted Array
 *
 * Easy
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
fun main() {
    val nums = intArrayOf(-5, -3, -2, -1)
    println(sortedSquares(nums).contentToString())
}

/**
 * two pointers
 *
 * Используйте два указателя, начинающихся с противоположных концов исходного отсортированного массива. Поскольку наибольшие квадратные значения
 * берутся из крайних значений (наиболее отрицательных или наиболее положительных чисел), сравните квадраты обоих значений указателя. Для указателя
 * с большим значением добавьте это значение к индексу, где бы ни находился трекер индекса. Затем переместите этот указатель внутрь (к центру)
 * и продолжайте заполнять результирующий массив справа налево.
 *
 * Переменная трекера должна начинаться с самого правого индекса, поскольку мы сначала добавляем самые большие числа, а наши выходные данные должны
 * быть в неубывающем порядке слева направо.
 */
fun sortedSquares(nums: IntArray): IntArray {
    val squareNums = IntArray(nums.size)
    var squareNumsIndex = squareNums.size - 1
    var left = 0
    var right = nums.size - 1

    while (squareNumsIndex >= 0) {
        val leftSquare = nums[left] * nums[left]
        val rightSquare = nums[right] * nums[right]

        if (rightSquare > leftSquare) {
            squareNums[squareNumsIndex--] = rightSquare
            right--
        } else {
            squareNums[squareNumsIndex--] = leftSquare
            left++
        }
    }

    return squareNums
}