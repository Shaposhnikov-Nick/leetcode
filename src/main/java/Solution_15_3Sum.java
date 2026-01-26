import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15_3Sum {
    public static void main(String[] args) {
        var nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        // Сортируем массив
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Проходим по всем элементам, которые могут быть первым числом в тройке
        for (int i = 0; i < nums.length - 2; i++) {
            // Пропускаем дубликаты для первого числа
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Нашли тройку
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Пропускаем дубликаты для left и right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    // Сумма слишком мала, увеличиваем left
                    left++;
                } else {
                    // Сумма слишком велика, уменьшаем right
                    right--;
                }
            }
        }

        return result;
    }
}

