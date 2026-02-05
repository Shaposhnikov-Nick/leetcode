import java.util.Arrays;
import java.util.HashSet;

public class Solution_217_ContainsDuplicate {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4};
        containsDuplicate(nums);
    }

    private static boolean containsDuplicate(int[] nums) {
        var seen = new HashSet<Integer>();
        return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
    }
}