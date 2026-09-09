import java.util.Arrays;

public class Solution_561_ArrayPartition {
    public static void main(String[] args) {
        var nums = new int[]{6, 2, 6, 5, 1, 2};
        arrayPairSum(nums);
    }

    private static int arrayPairSum(int[] nums) {
        var n = nums.length;

        // массив для хранения минимальных цифр в паре
        var minArray = new int[n / 2];
        var sum = 0;

        // сортируем массив
        Arrays.sort(nums);

        // индекс первого числа в паре в nums
        var i = 0;
        // индекс минимального числа в minArray
        var j = 0;
        while (i < n - 1) {
            // ищем минимальное число в паре
            // хотя можно просто брать первое с индексом i
            var minValue = Math.min(nums[i], nums[i + 1]);
            // и добаляем его в minArray
            minArray[j] = minValue;
            i += 2;
            j++;
        }

        // ищем сумму всех минимальных чисел
        for (var num : minArray) {
            sum += num;
        }

        return sum;
    }
}
