import java.util.Map;

public class Solution_1456_MaximumNumberOfVowelsInSubstringOfGivenLength {

    public static void main(String[] args) {
        var s = "abciiidef";
        var k = 3;
        System.out.println(maxVowels(s, k));
    }

    private static int maxVowels(String s, int k) {
        var maxVowelsCount = 0;
        var currentVowelsCount = 0;
        var chars = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (isVowel(chars[i])) currentVowelsCount++;
        }
        maxVowelsCount = currentVowelsCount;

        for (int i = k; i < chars.length; i++) {
            if (isVowel(chars[i - k])) currentVowelsCount--;
            if (isVowel(chars[i])) currentVowelsCount++;
            maxVowelsCount = Math.max(maxVowelsCount, currentVowelsCount);
            if (maxVowelsCount == k) return maxVowelsCount;
        }

        return maxVowelsCount;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
