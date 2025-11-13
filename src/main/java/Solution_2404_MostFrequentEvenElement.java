import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution_2404_MostFrequentEvenElement {
    public static void main(String[] args) {
        var nums = new int[]{0, 1, 2, 2, 4, 4, 1};
        mostFrequentEven(nums);
    }

    private static int mostFrequentEven(int[] nums) {
        // преобразование в мапу число-количество
        var frequencyMap = Arrays.stream(nums)
                .filter(num -> num % 2 == 0)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        if (frequencyMap.isEmpty()) return -1;

        // поиск максимального значения частоты
        var maxFrequency = frequencyMap.values().stream().max(Long::compareTo).get();

        return frequencyMap.entrySet()
                .stream()
                .filter(s -> Objects.equals(s.getValue(), maxFrequency)) // оставляем только те пары число-количество, у которых максимальное количество
                .map(Map.Entry::getKey) // преобразуем в список ключей
                .min(Integer::compareTo) // берем меньший ключ
                .get();
    }
}
