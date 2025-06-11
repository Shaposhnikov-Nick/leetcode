public class Solution_38_CountAndSay {
    public static void main(String[] args) {
        var n = 4;
        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = countAndSay(n - 1);
        var result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(prev.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }
}
