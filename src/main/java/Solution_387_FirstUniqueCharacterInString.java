import java.util.HashMap;

public class Solution_387_FirstUniqueCharacterInString {
    public static void main(String[] args) {
        var s = "leetcode";
        firstUniqChar(s);
    }

    private static int firstUniqChar(String s) {
        var map = new HashMap<Character, Integer>();
        var charArr = s.toCharArray();

        for (char ch : charArr) {
            map.merge(ch, 1, Integer::sum);
        }

        for (char ch : charArr) {
            if (map.get(ch) == 1) return s.indexOf(ch);
        }

        return -1;
    }
}
