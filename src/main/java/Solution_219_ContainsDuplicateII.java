import java.util.HashMap;

public class Solution_219_ContainsDuplicateII {
    public static void main(String[] args) {
        var nums = new int[]{1, 0, 1, 1};
        var k = 1;
        containsNearbyDuplicate(nums, k);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                var prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
