import java.util.ArrayDeque;

public class Solution_150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        var tokens = new String[]{"4", "13", "5", "/", "+"};
        evalRPN(tokens);
    }

    /**
     * Используем стек, чтобы хранить числа
     * Проходимся по все токенам в массиве
     * Если токен является числом, добавляем его в стек
     * Если токен является оператором, достаем из стека два последних добавленных числа и применяем к ним оператор
     * Полученный результат вычисления добавляем в стек
     * После выполнения всех операций в стеке останется одно число - результат всех вычислений
     */
    private static int evalRPN(String[] tokens) {
        // Используем стек, чтобы хранить числа
        var numStack = new ArrayDeque<Integer>();

        // Проходимся по все токенам в массиве
        for (var token : tokens) {
            if (!isOperator(token)) {
                // Если токен является числом, добавляем его в стек
                numStack.addLast(Integer.parseInt(token));
            } else {
                // Если токен является оператором, достаем из стека два последних добавленных числа
                // и применяем к ним оператор
                var num1 = numStack.removeLast();
                var num2 = numStack.removeLast();
                var result = 0;
                switch (token) {
                    case "+" -> result = num2 + num1;
                    case "-" -> result = num2 - num1;
                    case "*" -> result = num2 * num1;
                    case "/" -> result = num2 / num1;
                }
                // Полученный результат вычисления добавляем в стек
                numStack.addLast(result);
            }
        }

        // После выполнения всех операций в стеке останется одно число - результат всех вычислений
        return numStack.removeLast();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
