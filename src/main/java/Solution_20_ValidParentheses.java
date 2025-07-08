import java.util.ArrayDeque;

public class Solution_20_ValidParentheses {
    public static void main(String[] args) {
        var s = "(){}[]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()
                        || (ch == ')' && stack.peek() != '(')
                        || (ch == ']' && stack.peek() != '[')
                        || (ch == '}' && stack.peek() != '{')
                ) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
