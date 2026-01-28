import java.util.HashMap;

public class Solution_525_ContiguousArray {
    public static void main(String[] args) {
        var nums = new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0};
        findMaxLength(nums);
    }

    private static int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);

        var count = 0;
        var maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count += 1;
            else count += -1;

            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLength;
    }
}
