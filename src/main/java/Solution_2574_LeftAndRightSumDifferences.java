public class Solution_2574_LeftAndRightSumDifferences {
    public static void main(String[] args) {
        var nums = new int[]{10, 4, 8, 3};
        leftRightDifference(nums);
    }

    private static int[] leftRightDifference(int[] nums) {
        var n = nums.length;
        var leftSum = new int[n];
        var rightSum = new int[n];
        var answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) leftSum[i] = 0;
            else leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) rightSum[i] = 0;
            else rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}
