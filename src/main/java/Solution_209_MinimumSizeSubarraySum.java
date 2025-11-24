public class Solution_209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        var nums = new int[]{2, 3, 1, 2, 4, 3};
        var target = 7;
        minSubArrayLen(target, nums);
    }

    private static int minSubArrayLen(int target, int[] nums) {
        var left = 0;
        var currentSum = 0;
        var minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                currentSum -= nums[left];
                minLength = Math.min(minLength, right - left + 1);
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return 0;
        else return minLength;
    }
}
