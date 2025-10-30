import java.util.Arrays;
import java.util.HashMap;

public class Solution_169_MajorityElement {
    public static void main(String[] args) {
        var nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > nums.length / 2)
                .findFirst()
                .get()
                .getKey();
    }
}
