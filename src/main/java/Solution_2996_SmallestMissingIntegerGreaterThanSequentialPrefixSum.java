import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_2996_SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static void main(String[] args) {
        var nums = new int[]{3, 4, 5, 1, 12, 14, 13};
        missingInteger(nums);
    }

    /**
     * Объяснение алгоритма:
     * <p>
     * Находим сумму префикса:
     * Начинаем с nums[0]
     * Пока следующий элемент равен предыдущему + 1, добавляем его к сумме
     * Останавливаемся, когда последовательность прерывается
     * <p>
     * Ищем пропущенное число:
     * Начинаем с sum (суммы префикса)
     * Пока это число есть в массиве, увеличиваем его на 1
     * Возвращаем первое число, которого нет в массиве
     */
    private static int missingInteger(int[] nums) {
        // Находим сумму префикса: Начинаем с nums[0]
        var prefixSum = nums[0];
        var i = 1;

        // Пока следующий элемент равен предыдущему + 1, добавляем его к сумме
        // Останавливаемся, когда последовательность прерывается
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            prefixSum += nums[i];
            i++;
        }

        var numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        // Ищем пропущенное число:
        // Начинаем с sum (суммы префикса)
        // Пока это число есть в массиве, увеличиваем его на 1
        // Возвращаем первое число, которого нет в массиве
        while (numsSet.contains(prefixSum))
            prefixSum++;

        return prefixSum;
    }
}
