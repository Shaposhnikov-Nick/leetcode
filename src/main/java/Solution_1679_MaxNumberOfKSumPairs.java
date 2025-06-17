import java.util.Arrays;

public class Solution_1679_MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        var nums = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        var k = 3;
        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        var left = 0;
        var right = nums.length - 1;
        var counter = 0;

        while (left < right) {
            var sum = nums[left] + nums[right];
            if (sum == k) {
                counter++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }

        return counter;
    }
}
