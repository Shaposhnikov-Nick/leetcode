public class Solution_3090_MaximumLengthSubstringWithTwoOccurrences {
    public static void main(String[] args) {
        var s = "bcbbbcba";
        maximumLengthSubstring(s);
    }

    private static int maximumLengthSubstring(String s) {
        var maxLength = 0;
        var left = 0;
        var sArr = s.toCharArray();
        var charCount = new int[26];

        for (int right = 0; right < sArr.length; right++) {
            var currentChar = sArr[right];
            charCount[currentChar - 'a']++;

            while (charCount[currentChar - 'a'] > 2) {
                var leftChar = sArr[left];
                charCount[leftChar - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
