import java.util.ArrayDeque;

public class Solution_394_DecodeString {
    public static void main(String[] args) {
        var s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    private static String decodeString(String s) {
        // стек для хранения результирующей строки
        var stack = new ArrayDeque<Character>();
        var sArr = s.toCharArray();

        // добавляем в стек все символы до ]
        for (char ch : sArr) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                // если встречаем ], то декодируем строку в стеке до первого [
                var decodedString = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    decodedString.insert(0, stack.pop());
                }

                // удаляем [
                stack.pop();

                // ищем число, сколько раз повторить decodedString
                var countStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    countStr.insert(0, stack.pop());
                }
                var count = Integer.parseInt(countStr.toString());

                // повторяем строку decodedString count раз
                var fullString = new StringBuilder();
                fullString.repeat(decodedString, count);

                // добавляем результирующую строку посимвольно в stack
                var fsArr = fullString.toString().toCharArray();
                for (char ch1 : fsArr) {
                    stack.push(ch1);
                }
            }
        }

        // собираем строку из стека
        var result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}