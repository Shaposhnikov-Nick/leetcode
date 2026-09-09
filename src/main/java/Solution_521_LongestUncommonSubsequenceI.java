public class Solution_521_LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        var a = "aba";
        var b = "cdc";
        findLUSlength(a, b);
    }

    private static int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        else return Math.min(a.length(), b.length());
    }
}
