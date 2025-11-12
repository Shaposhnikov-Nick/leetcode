import java.util.*;

public class Solution_1636_SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        var nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        frequencySort(nums);
    }

    private static int[] frequencySort(int[] nums) {
        var frequency = new HashMap<Integer, Integer>();

        // считаем количество вхождений каждого числа
        Arrays.stream(nums).forEach(num -> frequency.merge(num, 1, Integer::sum));

        // компаратор вначале сравнивает количество вхождений каждого числа по возрастанию
        // если количество одинаковое, то сравниваются числа в обратном порядке для сортировки по убыванию
        var comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                var freqA = frequency.get(a);
                var freqB = frequency.get(b);
                if (Objects.equals(freqA, freqB)) return b - a;
                else return freqA - freqB;
            }
        };

        // сортируем массив с этим компаратором
        return Arrays.stream(nums)
                .boxed()
                .sorted(comparator)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

