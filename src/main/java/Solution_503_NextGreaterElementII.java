import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution_503_NextGreaterElementII {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 3};
        nextGreaterElements(nums);
    }

    private static int[] nextGreaterElements(int[] nums) {
        var n = nums.length;
        var stack = new ArrayDeque<Integer>();
        var result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * n; i++) {
            var currentIndex = i % n;
            var currentValue = nums[currentIndex];

            while (!stack.isEmpty() && nums[stack.getLast()] < currentValue) {
                var prevIndex = stack.removeLast();
                result[prevIndex] = currentValue;
            }

            if (i < n) {
                stack.addLast(currentIndex);
            }
        }

        return result;
    }
}
