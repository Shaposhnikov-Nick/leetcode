import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution_40_CombinationSumII {
    public static void main(String[] args) {
        var candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        var target = 8;
        combinationSum2(candidates, target);
    }

    /**
     * Сортировка массива позволяет эффективно обрабатывать дубликаты и выполнять отсечение
     * <p>
     * Метод backtrack рекурсивно перебирает комбинации, начиная с индекса start
     * <p>
     * Пропуск дубликатов (if (i > start && sorted[i] == sorted[i - 1]) continue) гарантирует, что мы не добавим одинаковые комбинации в результат
     * <p>
     * Отсечение (if (num > remaining) break) прерывает цикл, так как все последующие числа будут больше
     * <p>
     * Каждое число используется не более одного раза, поэтому следующий вызов начинается с i + 1
     * <p>
     * Пример работы:
     * <p>
     * Для candidates = [10,1,2,7,6,1,5], target = 8
     * <p>
     * После сортировки: [1,1,2,5,6,7,10]
     * <p>
     * Результат: [[1,1,6], [1,2,5], [1,7], [2,6]]
     */
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<Integer>(), result, candidates);
        return result;
    }

    private static void backtrack(int start, int remaining, List<Integer> current, List<List<Integer>> result, int[] candidates) {
        // Если осталось 0, значит нашли подходящую комбинацию
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Пропускаем дубликаты на том же уровне рекурсии
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            var num = candidates[i];

            // Если текущее число больше оставшейся суммы, прерываем цикл
            if (num > remaining) break;

            current.add(num);
            backtrack(i + 1, remaining - num, current, result, candidates); // i + 1, потому что каждое число можно использовать только один раз
            current.removeLast(); // Откатываем изменения
        }
    }
}

