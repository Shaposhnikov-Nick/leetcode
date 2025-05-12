public class Solution_1768_MergeStringsAlternately {
    public static void main(String[] args) {
        var word1 = "abc";
        var word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        var maxLength = Math.max(word1.length(), word2.length());
        var builder = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) builder.append(word1.charAt(i));
            if (i < word2.length()) builder.append(word2.charAt(i));
        }

        return builder.toString();
    }
}
