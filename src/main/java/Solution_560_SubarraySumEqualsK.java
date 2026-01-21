import java.util.HashMap;

public class Solution_560_SubarraySumEqualsK {
    public static void main(String[] args) {
        var nums = new int[]{1, 1, 1};
        var k = 2;
        subarraySum(nums, k);
    }

    private static int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        var currentSum = 0;
        var count = 0;

        map.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // Ищем, была ли раньше сумма (currentSum - k)
            var target = currentSum - k;
            count += map.getOrDefault(target, 0);

            // Обновляем частоту текущей суммы
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
