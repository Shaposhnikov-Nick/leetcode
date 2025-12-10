import java.util.ArrayDeque

/**
 * 1047 Remove All Adjacent Duplicates In String
 *
 * Easy
 *
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
fun main() {
    val s = "abbaca"
    removeDuplicates(s)
}

/**
 * Алгоритм:
 *
 * Если стек пустой, добавляем наверх стека символ
 *
 * Если стек не пустой, проверяем символ сверху и если он равен символу из строки, удаляем его из стека
 *
 * Собираем символы в строку начиная снизу стека, т.к. в стеке символы в обратном порядке
 */
fun removeDuplicates(s: String): String {
    val stack = ArrayDeque<Char>()

    for (ch in s) {
        if (stack.isNotEmpty() && stack.peek() == ch) stack.pop()
        else stack.push(ch)

        /* alternative
        if (stack.isEmpty()) {
            stack.push(ch)
        } else {
            val top = stack.peek()
            if (ch == top) stack.pop()
            else stack.push(ch)
        }
        */
    }

    val builder = StringBuilder()
    while (stack.isNotEmpty()) {
        builder.append(stack.removeLast())
    }

    return builder.toString()
}