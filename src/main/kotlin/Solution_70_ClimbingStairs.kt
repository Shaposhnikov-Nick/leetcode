/**
 * 70 Climbing Stairs
 *
 * Easy
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
fun main() {
    val n = 6
    println(climbStairs(n))
}

/**
 * Описание решения:
 * Базовые случаи:
 *
 * Если ступенек всего 1, то способ только один.
 *
 * Если ступенек 2, то способа два (1+1 или 2).
 *
 * Динамическое программирование:
 *
 * Создаем массив dp, где dp[i] будет хранить количество способов подняться на i-ю ступеньку.
 *
 * Для каждой ступеньки i > 2 количество способов равно сумме способов для i-1 и i-2, так как мы можем прийти на
 * i-ю ступеньку либо с (i-1)-й (сделав 1 шаг), либо с (i-2)-й (сделав 2 шага).
 */
fun climbStairs(n: Int): Int {
    if (n == 1) return 1
    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}