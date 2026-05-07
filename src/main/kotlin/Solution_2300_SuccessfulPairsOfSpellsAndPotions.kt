import java.util.Arrays

/**
 * 2300. Successful Pairs of Spells and Potions
 *
 * Medium
 *
 * You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 *
 * You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
 *
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 *
 *
 *
 * Example 1:
 *
 * Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * Output: [4,0,3]
 * Explanation:
 * - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
 * - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
 * - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
 * Thus, [4,0,3] is returned.
 * Example 2:
 *
 * Input: spells = [3,1,2], potions = [8,5,8], success = 16
 * Output: [2,0,2]
 * Explanation:
 * - 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
 * - 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
 * - 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
 * Thus, [2,0,2] is returned.
 *
 *
 * Constraints:
 *
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 105
 * 1 <= spells[i], potions[i] <= 105
 * 1 <= success <= 1010
 */
fun main() {
    val spells = intArrayOf(5, 1, 3)
    val potions = intArrayOf(1, 2, 3, 4, 5)
    val success = 7

    successfulPairs(spells, potions, success.toLong())
}

/**
 * Сортируем массив potions по возрастанию
 * Для каждого заклинания ищем минимально подхоядящее значение зелья, чтобы оно укладывалось в логику
 * spell * potion >= success
 * Ищем индекс этого значения зелья в массиве potions
 * В result добавляем, сколько еще зелий есть больше этого значения (разница всей длины массива и индекса минимального зелья)
 * O((n+m) log m)
 */
fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val result = IntArray(spells.size)
    // Сортируем массив potions по возрастанию
    Arrays.sort(potions)

    fun lowerBound(target: Long, potions: IntArray): Int {
        var left = 0
        var right = potions.size

        // Для каждого заклинания ищем минимально подхоядящее значение зелья, чтобы оно укладывалось в логику
        // spell * potion >= success
        // этот математический трюк  аналогичен коду
        // Способ 1: через Math.ceil (но с плавающей точкой - риск погрешности)
        //            long minPotion = (long) Math.ceil((double) success / spells[i]);
        // Способ 2: без магии, но понятнее
        //            long minPotion = success / spells[i];
        //            if (success % spells[i] != 0) {
        //                minPotion++;
        //            }
        while (left < right) {
            val mid = left + (right - left) / 2
            if (target <= potions[mid]) right = mid
            else left = mid + 1
        }

        return left
    }

    for (i in spells.indices) {
        val minPotion = (success + spells[i] - 1) / spells[i]
        val index = lowerBound(minPotion, potions)
        result[i] = potions.size - index
    }

    return result
}