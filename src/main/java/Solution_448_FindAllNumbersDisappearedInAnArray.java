import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        var nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers(nums);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        var result = new ArrayList<Integer>();
        var set = new HashSet<Integer>();

        for (var num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
