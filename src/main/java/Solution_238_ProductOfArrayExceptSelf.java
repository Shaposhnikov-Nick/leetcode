import java.util.Arrays;

public class Solution_238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        var prefix = new int[nums.length];
        var postfix = new int[nums.length];

        // find prefix
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
        }

        // find postfix
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = 1;
            } else {
                postfix[i] = postfix[i + 1] * nums[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }
}
