/**
 * 150. Evaluate Reverse Polish Notation
 *
 * Medium
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
fun main() {
    val tokens = arrayOf("4", "13", "5", "/", "+")
    evalRPN(tokens)
}

/**
 * Используем стек, чтобы хранить числа
 * Проходимся по все токенам в массиве
 * Если токен является числом, добавляем его в стек
 * Если токен является оператором, достаем из стека два последних добавленных числа и применяем к ним оператор
 * Полученный результат вычисления добавляем в стек
 * После выполнения всех операций в стеке останется одно число - результат всех вычислений
 */
fun evalRPN(tokens: Array<String>): Int {
    // Используем стек, чтобы хранить числа
    val stack = ArrayDeque<Int>()

    // Проходимся по все токенам в массиве
    for (token in tokens) {
        when (token) {
            // Если токен является оператором, достаем из стека два последних добавленных числа и применяем к ним оператор
            // Полученный результат вычисления добавляем в стек
            "+" -> stack.addLast(stack.removeLast() + stack.removeLast())
            "*" -> stack.addLast(stack.removeLast() * stack.removeLast())
            "-" -> {
                val num1 = stack.removeLast()
                val num2 = stack.removeLast()
                stack.addLast(num2 - num1)
            }

            "/" -> {
                val num1 = stack.removeLast()
                val num2 = stack.removeLast()
                stack.addLast(num2 / num1)
            }

            // Если токен является числом, добавляем его в стек
            else -> stack.addLast(token.toInt())
        }
    }

    // После выполнения всех операций в стеке останется одно число - результат всех вычислений
    return stack.removeLast()
}