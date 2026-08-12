import java.util.ArrayList;
import java.util.HashMap;

public class Solution_599_MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        var list1 = new String[]{"happy", "sad", "good"};
        var list2 = new String[]{"sad", "happy", "good"};
        findRestaurant(list1, list2);
    }

    /**
     * Добавляем слова и их индексы из списка list1 в мапу map1
     * Проходим по list2 и для каждого слова ищем его индекс в list1
     * Если слово есть в list1, складываем оба индекса и сравниваем с последним меньшим
     * Если новая сумма меньше предыдущей, удаляем из result старые слова и добавляем новое
     * Если новая сумма равна предыдущей, добавляем новое слово
     */
    private static String[] findRestaurant(String[] list1, String[] list2) {
        var map1 = new HashMap<String, Integer>();
        var result = new ArrayList<String>();
        var minIndexSum = Integer.MAX_VALUE;

        // Добавляем слова и их индексы из списка list1 в мапу map1
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        // Проходим по list2 и для каждого слова ищем его индекс в list1
        for (int i = 0; i < list2.length; i++) {
            var word = list2[i];
            var index1 = map1.get(word);
            // Если слово есть в list1
            if (index1 != null) {
                // складываем оба индекса и сравниваем с последним меньшим
                var indexSum = i + index1;
                // Если новая сумма меньше предыдущей, удаляем из result старые слова и добавляем новое
                if (indexSum < minIndexSum) {
                    result.clear();
                    result.add(word);
                    minIndexSum = i + index1;
                    // Если новая сумма равна предыдущей, добавляем новое слово
                } else if (indexSum == minIndexSum) {
                    result.add(word);
                }
            }
        }

        return result.toArray(new String[]{});
    }
}
