import java.util.HashMap;

public class Solution_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        var s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        var maxLength = 0;
        var map = new HashMap<Character, Integer>();
        var arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1);
            var j = i + 1;
            while (j < arr.length) {
                var count = map.putIfAbsent(arr[j], 1);
                if (count != null) {
                    maxLength = Math.max(maxLength, map.size());
                    map.clear();
                    break;
                }
                j++;
            }
        }

        return Math.max(maxLength, map.size());
    }
}
