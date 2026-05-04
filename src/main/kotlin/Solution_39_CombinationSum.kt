/**
 * 39. Combination Sum
 *
 * Medium
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */
fun main() {
    val candidates = intArrayOf(2, 3, 6, 7)
    val target = 7
    combinationSum(candidates, target)
}

/**
 * Используем рекурсию и обход в ширину DFS (Depth-First Search)
 * Вычитаем из target каждый num из candidates, если получили 0 - значит нашли последнее число в списке подходящих,
 * если больше 0 - значит опять во всем списке candidates рекурсивно ищем другое подходящее число,
 * если меньше 0 - останавливаем поиск для это цепочки
 * Т.к. в результируюем списке могут быть дубликаты комбинаций в другом порядке, сортируем каждую комбинацию
 * и оставляем только уникальные
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val combinations = mutableListOf<List<Int>>()

    for (num in candidates) {
        val currentCombination = mutableListOf<Int>()
        getNextCombinationNumDfs(num, target, currentCombination, combinations, candidates)
    }

    // Т.к. в результируюем списке могут быть дубликаты комбинаций в другом порядке, сортируем каждую комбинацию
    // и оставляем только уникальные
    return combinations.map { it.sorted() }.distinct()
}

fun getNextCombinationNumDfs(
    num: Int, target: Int, currentCombination: MutableList<Int>, combinations: MutableList<List<Int>>, candidates: IntArray
) {
    // Вычитаем из target каждый num из candidates
    val value = target - num
    if (value == 0) {
        // если получили 0 - значит нашли последнее число в списке подходящих
        // останавливаем эту цепочку и добавляем в resultList
        currentCombination.add(num)
        combinations.add(currentCombination)
    } else if (value > 0) {
        // если больше 0 - значит опять во всем списке candidates рекурсивно ищем другое подходящее число
        currentCombination.add(num)
        candidates.forEach {
            getNextCombinationNumDfs(it, value, ArrayList<Int>(currentCombination), combinations, candidates)
        }
    }
}