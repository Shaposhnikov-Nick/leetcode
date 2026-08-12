/**
 * 599 Minimum Index Sum of Two Lists
 *
 * Easy
 *
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 *
 * A common string is a string that appeared in both list1 and list2.
 *
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 *
 * Return all the common strings with the least index sum. Return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only common string is "Shogun".
 * Example 2:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
 * Example 3:
 *
 * Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
 * Output: ["sad","happy"]
 * Explanation: There are three common strings:
 * "happy" with index sum = (0 + 1) = 1.
 * "sad" with index sum = (1 + 0) = 1.
 * "good" with index sum = (2 + 2) = 4.
 * The strings with the least index sum are "sad" and "happy".
 *
 *
 * Constraints:
 *
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the strings of list1 are unique.
 * All the strings of list2 are unique.
 * There is at least a common string between list1 and list2.
 */
fun main() {
    val list1 = arrayOf("happy", "sad", "good")
    val list2 = arrayOf("sad", "happy", "good")
    findRestaurant(list1, list2)
}

/**
 * Добавляем слова и их индексы из списка list1 в мапу map1
 * Проходим по list2 и для каждого слова ищем его индекс в list1
 * Если слово есть в list1, складываем оба индекса и сравниваем с последним меньшим
 * Если новая сумма меньше предыдущей, удаляем из result старые слова и добавляем новое
 * Если новая сумма равна предыдущей, добавляем новое слово
 */
fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    val map1 = mutableMapOf<String, Int>()
    val result = mutableListOf<String>()
    var minIndexSum = Int.MAX_VALUE

    // Добавляем слова и их индексы из списка list1 в мапу map1
    list1.forEachIndexed { index, word -> map1[word] = index }

    // Проходим по list2 и для каждого слова ищем его индекс в list1
    list2.forEachIndexed { index2, word ->
        // Если слово есть в list1, складываем оба индекса и сравниваем с последним меньшим
        map1[word]?.let { index1 ->
            val sumIndex = index1 + index2
            // Если новая сумма меньше предыдущей, удаляем из result старые слова и добавляем новое
            if (sumIndex < minIndexSum) {
                result.clear()
                result.add(word)
                minIndexSum = sumIndex
                // Если новая сумма равна предыдущей, добавляем новое слово
            } else if (sumIndex == minIndexSum) {
                result.add(word)
            }
        }
    }

    return result.toTypedArray()
}