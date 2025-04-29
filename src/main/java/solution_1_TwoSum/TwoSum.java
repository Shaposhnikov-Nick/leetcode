package solution_1_TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        var nums = new int[]{2, 7, 11, 15};
        var target = 9;
        var result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        var result = new int[2];
        var numsMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var find = target - nums[i];
            if (numsMap.containsKey(find)) {
                result[0] = i;
                result[1] = numsMap.get(find);
                break;
            }
            numsMap.put(nums[i], i);
        }

        return result;
    }
}
