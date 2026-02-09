import java.util.Arrays;

public class Solution_268_MissingNumber {
    public static void main(String[] args) {
        var nums = new int[]{0, 1};
        missingNumber(nums);
    }

    private static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        var n = nums.length;
        if (nums[0] != 0) return 0;
        if (nums[n - 1] != n) return n;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                return nums[i - 1] + 1;
            }
        }

        return -1;
    }

    /**
     * Считаем, какая сумма должна быть в случае, если нет пропущенного числа
     * Считаем фактическую сумму чисел в массиве
     * Находим разность полной суммы и фактической
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        // Считаем, какая сумма должна быть в случае, если нет пропущенного числа
        int totalSum = n * (n + 1) / 2;
        int sum = 0;
        // Считаем фактическую сумму чисел в массиве
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        // Находим разность полной суммы и фактической
        return totalSum - sum;
    }
}
