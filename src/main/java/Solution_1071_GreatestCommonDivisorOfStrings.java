public class Solution_1071_GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        var str1 = "ABABAB";
        var str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        var divisor = str1;
        if (str2.length() < str1.length()) divisor = str2;

        while (!divisor.isEmpty()) {
            if (isValid(str1, divisor) && isValid(str2, divisor)) return divisor;
            divisor = divisor.substring(0, divisor.length() - 1);
        }

        return "";
    }

    public static boolean isValid(String str, String divisor) {
        if (str.length() % divisor.length() != 0) return false;
        int i = 0;
        int j = divisor.length();
        while (j <= str.length()) {
            if (!str.substring(i, j).equals(divisor)) return false;
            i += divisor.length();
            j += divisor.length();
        }
        return true;
    }
}
