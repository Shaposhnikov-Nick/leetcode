import java.util.List;

public class Solution_3364_MinimumPositiveSumSubarray {
    public static void main(String[] args) {
        var nums = List.of(3, -2, 1, 4);
        int l = 1, r = 1;
        minimumSumSubarray(nums, l, r);
    }

    /**
     * Для каждой длины подмассива ищем тот, который меньше всего в сумме элементов
     * Используем скользящее окно длиной от l до r (то есть длиной с каждый подмассив)
     * Считаем сумму для первого подмассива
     * Далее двигаем указатель на единицу вправо и считаем новую сумму подмассива: удаляем левое значение и прибавляем правое.
     * Каждый раз сравниваем получившееся значение с уже ранее найденным минимальным
     */
    private static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        var minSum = -1;

        // Для каждой длины подмассива ищем тот, который меньше всего в сумме элементов
        for (int length = l; length <= r; length++) {
            // Текущая сумма каждого подмассива
            var currentMinSum = 0;

            // Используем скользящее окно длиной от l до r (то есть длиной с каждый подмассив)
            var j = 0;
            // Считаем префиксную сумму для первого подмассива
            while (j < length) {
                currentMinSum += nums.get(j);
                j++;
            }
            // Сравниваем получившееся значение с уже ранее найденным минимальным или -1
            if (currentMinSum > 0) {
                if (minSum == -1) minSum = currentMinSum;
                else minSum = Math.min(minSum, currentMinSum);
            }
            // Далее двигаем указатель на единицу вправо и считаем новую сумму подмассива: удаляем левое значение и прибавляем правое.
            while (j < nums.size()) {
                currentMinSum = currentMinSum + nums.get(j) - nums.get(j - length);
                // Каждый раз сравниваем получившееся значение с уже ранее найденным минимальным
                if (currentMinSum > 0) {
                    if (minSum == -1) minSum = currentMinSum;
                    else minSum = Math.min(minSum, currentMinSum);
                }
                j++;
            }
        }

        return minSum;
    }
}
