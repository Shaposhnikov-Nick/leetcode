import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_3731_FindMissingElements {
    public static void main(String[] args) {
        var nums = new int[]{2, 7, 4, 5};
        findMissingElements(nums);
    }

    private static List<Integer> findMissingElements(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        var result = new ArrayList<Integer>();
        var min = Arrays.stream(nums).min().getAsInt();
        var max = Arrays.stream(nums).max().getAsInt();

        for (int i = min; i <= max; i++) {
            if (!containsNum(nums, i)) result.add(i);
        }

        return result;
    }

    private static boolean containsNum(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }
}
