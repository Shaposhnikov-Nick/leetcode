public class Solution_151_ReverseWordsInString {
    public static void main(String[] args) {
        var s = "  a good   example   ";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        var builder = new StringBuilder();
        var chars = s.toCharArray();

        var startIndex = 0;
        var endIndex = 1;

        while (startIndex < endIndex && endIndex <= s.length()) {
            for (int i = startIndex; i < chars.length; i++) {
                if (Character.isWhitespace(chars[i])) {
                    startIndex++;
                    endIndex++;
                } else break;
            }

            for (int i = startIndex + 1; i < chars.length; i++) {
                if (!Character.isWhitespace(chars[i])) {
                    endIndex++;
                } else break;
            }

            if (startIndex < chars.length && endIndex <= chars.length) {
                var word = "";

                if (endIndex >= chars.length)
                    word = s.substring(startIndex);
                else
                    word = s.substring(startIndex, endIndex);


                if (builder.isEmpty())
                    builder.insert(0, word);
                else {
                    builder.insert(0, " ");
                    builder.insert(0, word);
                }
                startIndex = endIndex;
                endIndex++;
            }
        }

        return builder.toString();
    }
}
