public class Solution_643_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        var nums = new int[]{1, 12, -5, -6, 50, 3};
        var k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        double maxSum;
        double currentSum = 0;
        int left = 0;

        for (int i = 0; i < k; i++) currentSum += nums[i];

        maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum += (-nums[left] + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
            left++;
        }

        return maxSum / k;
    }

}
