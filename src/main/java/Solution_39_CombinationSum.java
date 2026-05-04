import java.util.ArrayList;
import java.util.List;

public class Solution_39_CombinationSum {
    public static void main(String[] args) {
        var candidates = new int[]{2, 3, 6, 7};
        var target = 7;
        combinationSum(candidates, target);
    }

    /**
     * Используем рекурсию и обход в ширину DFS (Depth-First Search)
     * Вычитаем из target каждый num из candidates, если получили 0 - значит нашли последнее число в списке подходящих,
     * если больше 0 - значит опять во всем списке candidates рекурсивно ищем другое подходящее число,
     * если меньше 0 - останавливаем поиск для это цепочки
     * Т.к. в результируюем списке могут быть дубликаты комбинаций в другом порядке, сортируем каждую комбинацию
     * и оставляем только уникальные
     */
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        var combinations = new ArrayList<List<Integer>>();

        for (var candidate : candidates) {
            var currentCombination = new ArrayList<Integer>();
            getNextCombinationNumDfs(candidate, target, currentCombination, candidates, combinations);
        }

        // Т.к. в результируюем списке могут быть дубликаты комбинаций в другом порядке, сортируем каждую комбинацию
        // и оставляем только уникальные
        return combinations.stream().map(list -> list.stream().sorted().toList()).distinct().toList();
    }

    private static void getNextCombinationNumDfs(Integer num, Integer target, ArrayList<Integer> currentCombination, int[] candidates, ArrayList<List<Integer>> combinations) {
        // Вычитаем из target каждый num из candidates
        var value = target - num;
        if (value == 0) {
            // если получили 0 - значит нашли последнее число в списке подходящих
            // останавливаем эту цепочку и добавляем в resultList
            currentCombination.add(num);
            combinations.add(currentCombination);
        } else if (value > 0) {
            // если больше 0 - значит опять во всем списке candidates рекурсивно ищем другое подходящее число
            currentCombination.add(num);
            for (var candidate : candidates) {
                getNextCombinationNumDfs(candidate, value, new ArrayList<>(currentCombination), candidates, combinations);
            }
        }
    }

}

