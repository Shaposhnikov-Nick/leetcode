import java.util.ArrayList;
import java.util.Arrays;

public class Solution_350_IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        var nums1 = new int[]{0, 1, 1, 2, 2, 4};
        var nums2 = new int[]{1, 1, 3};

        intersect(nums1, nums2);
    }

    /**
     * Используем метод двух указателей.
     * Сортируем оба массива в порядке возрастания.
     * Выбираем меньший и больший по размеру массив.
     * Проходим по каждому числу из меньшего массива и ищем такое же или большее число в большем массиве.
     * Если число совпало, добавляем в результирующий список и двигаем указатель на 1 ячейку вправо.
     * Если j вышел за границы большего массива, значит поиск окончен
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        var result = new ArrayList<Integer>();
        // Сортируем оба массива в порядке возрастания
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Выбираем меньший и больший по размеру массив
        var minArray = new int[]{};
        var maxArray = new int[]{};

        if (nums1.length < nums2.length) {
            minArray = nums1;
            maxArray = nums2;
        } else {
            minArray = nums2;
            maxArray = nums1;
        }


        // Проходим по каждому числу из меньшего массива
        for (int i = 0, j = 0; i < minArray.length; i++) {
            var v1 = minArray[i];
            // ищем такое же или большее число в большем массиве
            while (j < maxArray.length - 1 && v1 > maxArray[j])
                j++;

            // Если число совпало, добавляем в результирующий список и двигаем указатель на 1 ячейку вправо
            if (maxArray[j] == v1) {
                result.add(v1);
                j++;
            }

            // Если j вышел за границы большего массива, значит поиск окончен
            if (j >= maxArray.length) break;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
