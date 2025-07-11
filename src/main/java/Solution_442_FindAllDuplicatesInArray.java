import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_442_FindAllDuplicatesInArray {
    public static void main(String[] args) {
        var nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    private static List<Integer> findDuplicates(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey)
                .toList();
    }
}
