public class Solution_1004_MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        var nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        var k = 2;
        System.out.println(longestOnes(nums, k));
    }

    private static int longestOnes(int[] nums, int k) {
        var left = 0;
        var zeroCount = 0;
        var maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
