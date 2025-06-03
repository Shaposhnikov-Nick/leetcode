public class Solution_392_IsSubsequence {
    public static void main(String[] args) {
        var s = "aaaaa";
        var t = "bbaaaa";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        var tArray = t.toCharArray();
        var lastIndex = 0;
        var counter = 0;

        for (Character sChar : s.toCharArray()) {
            for (int i = lastIndex; i < t.length(); i++) {
                if (sChar.equals(tArray[i])) {
                    counter++;
                    lastIndex = i + 1;
                    break;
                }
            }
        }

        return counter == s.length();
    }
}
