/**
 * 20 Valid Parentheses
 *
 * Easy
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 */
fun main() {
    val s = "(]"
    println(isValid(s))
}

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    s.forEach { ch ->
        // открывающиеся скобки добавляем в стек
        if (ch == '[' || ch == '(' || ch == '{') stack.addFirst(ch)
        // если встречается закрывающаяся скобка, берем из стека верхнюю скобку
        // и проверяем, что эта пара скобок валидна, в этом случае удаляем открывающую скобку из стека
        if (ch == ']' || ch == ')' || ch == '}') {
            val last = stack.firstOrNull() ?: return false
            val parentheses = String(charArrayOf(last, ch))
            if (parentheses == "()" || parentheses == "{}" || parentheses == "[]") {
                stack.removeFirst()
            } else return false
        }
    }

    // если вся строка валидна, стек будет пустым
    return stack.isEmpty()
}