public class Solution_2485_FindThePivotInteger {
    public static void main(String[] args) {
        var n = 8;
        pivotInteger(n);
    }

    private static int pivotInteger(int n) {
        var leftPrefixSum = 0;
        var rightPrefixSum = 0;

        for (int i = 0; i <= n; i++) {
            rightPrefixSum += i;
        }

        for (int i = 1; i <= n; i++) {
            leftPrefixSum += i - 1;
            rightPrefixSum -= i;
            if (leftPrefixSum == rightPrefixSum) return i;
        }

        return -1;
    }
}
