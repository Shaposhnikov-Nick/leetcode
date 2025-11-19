import java.util.HashMap;

public class Solution_2341_MaximumNumberOfPairsInArray {
    public static void main(String[] args) {
        var nums = new int[]{1, 3, 2, 1, 3, 2, 2};
        numberOfPairs(nums);
    }

    private static int[] numberOfPairs(int[] nums) {
        var totalPairs = 0;
        var totalLeftover = 0;
        var map = new HashMap<Integer, Integer>();

        for (var num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (var entry : map.entrySet()) {
            var pairs = entry.getValue() / 2;
            var leftover = entry.getValue() % 2;
            totalPairs += pairs;
            totalLeftover += leftover;
        }

        return new int[]{totalPairs, totalLeftover};
    }
}
