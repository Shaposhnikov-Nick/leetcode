import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_496_NextGreaterElementI {
    public static void main(String[] args) {
        var nums1 = new int[]{4, 1, 2};
        var nums2 = new int[]{1, 3, 4, 2};
        nextGreaterElement(nums1, nums2);
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var nextGreater = new HashMap<Integer, Integer>();
        var stack = new ArrayDeque<Integer>();

        for (var num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                var smaller = stack.pop();
                nextGreater.put(smaller, num);
            }
            stack.push(num);
        }

        return Arrays.stream(nums1)
                .map(num -> nextGreater.getOrDefault(num, -1))
                .toArray();
    }
}
