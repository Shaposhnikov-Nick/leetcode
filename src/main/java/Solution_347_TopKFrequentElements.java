import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution_347_TopKFrequentElements {
    public static void main(String[] args) {
        var nums = new int[]{1, 1, 1, 2, 2, 3};
        var k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
