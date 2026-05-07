import java.util.Arrays;

public class Solution_2300_SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        var spells = new int[]{5, 1, 3};
        var potions = new int[]{1, 2, 3, 4, 5};
        var success = 7;

        successfulPairs(spells, potions, success);
    }

    /**
     * Сортируем массив potions по возрастанию
     * Для каждого заклинания ищем минимально подхоядящее значение зелья, чтобы оно укладывалось в логику
     * spell * potion >= success
     * Ищем индекс этого значения зелья в массиве potions
     * В result добавляем, сколько еще зелий есть больше этого значения (разница всей длины массива и индекса минимального зелья)
     * O((n+m) log m)
     */
    private static int[] successfulPairs(int[] spells, int[] potions, long success) {
        var result = new int[spells.length];
        // Сортируем массив potions по возрастанию
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            // Для каждого заклинания ищем минимально подхоядящее значение зелья, чтобы оно укладывалось в логику
            // spell * potion >= success
            // этот математический трюк  аналогичен коду
            // Способ 1: через Math.ceil (но с плавающей точкой - риск погрешности)
            //            long minPotion = (long) Math.ceil((double) success / spells[i]);
            // Способ 2: без магии, но понятнее
            //            long minPotion = success / spells[i];
            //            if (success % spells[i] != 0) {
            //                minPotion++;
            //            }
            long minPotion = (success + spells[i] - 1) / spells[i];
            var index = lowerBound(minPotion, potions);
            result[i] = potions.length - index;
        }

        return result;
    }

    private static int lowerBound(long target, int[] potions) {
        int left = 0, right = potions.length;

        // двигаем указатели до тех пор, пока не найдем target
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
