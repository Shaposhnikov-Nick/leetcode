import java.util.ArrayDeque

/**
 * 496 Next Greater Element I
 *
 * Easy
 *
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * Example 2:
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 */
fun main() {
    val nums1 = intArrayOf(4, 1, 2)
    val nums2 = intArrayOf(1, 3, 4, 2)
    nextGreaterElement(nums1, nums2)
}

/**
 * Алгоритм
 *
 * Мы сначала обработаем nums2, чтобы найти next greater element (NGE) для каждого элемента в нём.
 *
 * Для этого используем монотонно убывающий стек (decreasing stack).
 *
 * Сохраним результаты в Map<Int, Int>, где ключ — элемент из nums2, значение — его NGE.
 *
 * Затем пройдём по nums1 и просто возьмём ответы из мапы.
 */
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    // ключ - num из nums2, значение — его NGE
    val nextGreater = mutableMapOf<Int, Int>()
    val stack = ArrayDeque<Int>()

    // Проходим по nums2 слева направо
    for (num in nums2) {
        // Пока текущий элемент больше вершины стека — он является NGE для неё
        while (stack.isNotEmpty() && num > stack.last()) {
            val smaller = stack.removeLast()
            nextGreater[smaller] = num
        }
        stack.addLast(num)
    }

    // Оставшиеся элементы в стеке не имеют NGE → они уже не в мапе, значит NGE = -1
    return nums1.map { nextGreater.getOrDefault(it, -1) }.toIntArray()
}