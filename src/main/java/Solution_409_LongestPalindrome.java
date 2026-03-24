import java.util.HashMap;

public class Solution_409_LongestPalindrome {
    public static void main(String[] args) {
        var s = "abccccdd";
        longestPalindrome(s);
    }

    private static int longestPalindrome(String s) {
        var frequencyMap = new HashMap<Character, Integer>();

        for (var ch : s.toCharArray()) {
            frequencyMap.merge(ch, 1, Integer::sum);
        }

        var length = frequencyMap.values().stream().mapToInt(value -> value - (value % 2)).sum();
        var hasOdd = frequencyMap.values().stream().anyMatch(value -> value % 2 != 0);


        return hasOdd ? ++length : length;
    }
}
