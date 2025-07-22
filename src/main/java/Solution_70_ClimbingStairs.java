public class Solution_70_ClimbingStairs {
    public static void main(String[] args) {
        var n = 5;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        if (n == 1) return 1;
        var dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
