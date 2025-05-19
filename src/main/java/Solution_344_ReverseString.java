public class Solution_344_ReverseString {
    public static void main(String[] args) {
        var s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    private static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            var temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
