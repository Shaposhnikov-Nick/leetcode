import java.util.HashMap;

public class Solution_1122_Relative_Sort_Array {
    public static void main(String[] args) {
        var arr1 = new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        var arr2 = new int[]{2, 42, 38, 0, 43, 21};
        relativeSortArray(arr1, arr2);
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        var result = new int[arr1.length];
        var freqMap = new HashMap<Integer, Integer>();

        // Проходим по массиву arr1 и подсчитывем количество вхождений каждого числа
        for (var num : arr1) {
            freqMap.merge(num, 1, Integer::sum);
        }

        var i = 0;
        var j = 0;

        // Затем проходим по массиву arr2 и для каждого его значения записываем в массив result это значение определенное количество раз
        for (var num : arr2) {
            var count = freqMap.get(num);

            while (j < i + count) {
                result[j] = num;
                j++;
            }

            // при этом удаляем это число из freqMap
            freqMap.remove(num);
            i = j;
        }

        // После оставшиеся в freqMap значения сортируем в порядке возрастания и аналогичным способом записываем в result
        var nums = freqMap.keySet().stream().sorted().toList();

        for (var num : nums) {
            var count = freqMap.get(num);

            while (j < i + count) {
                result[j] = num;
                j++;
            }

            i = j;
        }

        return result;
    }
}
