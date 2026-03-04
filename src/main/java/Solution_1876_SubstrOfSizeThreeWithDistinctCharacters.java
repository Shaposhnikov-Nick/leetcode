import java.util.HashSet;

public class Solution_1876_SubstrOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        var s = "aababcabc";
        countGoodSubstrings(s);
    }

    private static int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;

        var left = 0;
        var right = 2;
        var goodSubstrings = 0;

        while (right < s.length()) {
            var substring = s.substring(left, right + 1);
            var set = new HashSet<Character>();

            for (var ch : substring.toCharArray()) {
                set.add(ch);
            }

            if (set.size() == substring.length()) goodSubstrings++;

            right++;
            left++;
        }

        return goodSubstrings;
    }

    public int countGoodSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        return count;
    }
}
