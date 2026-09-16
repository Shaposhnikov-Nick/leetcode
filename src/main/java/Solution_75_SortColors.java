public class Solution_75_SortColors {
    public static void main(String[] args) {
        var nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    /**
     * Сортируем массив подсчетом
     * Считаем количество 0, 1 и 2
     * Перезаписываем ячейки в массиве в соответствии с подсчитанным количеством
     */
    private static void sortColors(int[] nums) {
        var zeroCount = 0;
        var oneCount = 0;
        var twoCount = 0;

        for (int num : nums) {
            switch (num) {
                case 0 -> zeroCount++;
                case 1 -> oneCount++;
                case 2 -> twoCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < zeroCount) {
                nums[i] = 0;
            } else if (i < zeroCount + oneCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
