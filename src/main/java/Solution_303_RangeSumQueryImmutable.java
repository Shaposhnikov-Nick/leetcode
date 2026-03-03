import java.util.Arrays;

public class Solution_303_RangeSumQueryImmutable {
}

class NumArray {
    int[] prefixSumArr;

    // При создании объекта в конструкторе сразу высчитываются префиксные суммы для каждого индекса в массиве
    public NumArray(int[] nums) {
        prefixSumArr = new int[nums.length];
        var sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSumArr[i] = sum;
        }
    }

    // Зная префиксную сумму каждого индекса, возвращаем разность префиксных сумм этих индексов
    public int sumRange(int left, int right) {
        if (left == 0)
            return prefixSumArr[right];
        else
            return prefixSumArr[right] - prefixSumArr[left - 1];
    }
}