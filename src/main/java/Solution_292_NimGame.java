public class Solution_292_NimGame {
    public static void main(String[] args) {
        var n = 4;
        canWinNim(n);
    }

    private static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
