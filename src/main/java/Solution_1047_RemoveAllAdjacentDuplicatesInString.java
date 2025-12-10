import java.util.ArrayDeque;

public class Solution_1047_RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        var s = "abbaca";
        removeDuplicates(s);
    }

    /**
     * Using ArrayDeque
     */
    private static String removeDuplicates(String s) {
        var stack = new ArrayDeque<Character>();

        for (var ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(ch)) stack.pop();
            else stack.push(ch);
        }

        var builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeLast());
        }

        return builder.toString();
    }

    /**
     * Using only StringBuilder
     */
    private static String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1); // remove the duplicate
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
