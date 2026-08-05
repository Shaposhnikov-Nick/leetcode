import java.util.Arrays;

public class Solution_2389_LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        var nums = new int[]{4, 5, 2, 1};
        var queries = new int[]{3, 10, 21};
        answerQueries(nums, queries);
    }

    /**
     * Сортируем массив (чтобы получить максимальную длину подпоследовательности с минимальной суммой)
     * <p>
     * Строим префиксные суммы: [1, 3, 6, 10] для nums = [1, 2, 4, 5]
     * <p>
     * Для каждого запроса бинарным поиском находим максимальное количество элементов, сумма которых не превышает запрос
     */
    private static int[] answerQueries(int[] nums, int[] queries) {
        var result = new int[queries.length];
        var prefixSum = new int[nums.length];
        Arrays.sort(nums);

        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = search(prefixSum, queries[i]);
        }

        return result;
    }

    private static int search(int[] prefixSum, int target) {
        var left = 0;
        var right = prefixSum.length;

        while (left < right) {
            var mid = left + (right - left) / 2;
            if (prefixSum[mid] <= target) left = mid + 1;
            else right = mid;
        }

        return left; // количество элементов, сумма которых <= target
    }
}
