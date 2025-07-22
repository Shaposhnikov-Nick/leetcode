public class Solution_1493_LongestSubarrayOf1AfterDeletingOneElement {
    public static void main(String[] args) {
        var nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }

    private static int longestSubarray(int[] nums) {
        var left = 0;
        var zeroCount = 0;
        var longest = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            longest = Math.max(longest, right - left);
        }

        if (longest == nums.length) return nums.length - 1;
        else return longest;
    }
}
