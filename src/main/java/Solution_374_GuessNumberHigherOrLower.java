public class Solution_374_GuessNumberHigherOrLower {
    public static void main(String[] args) {
        var n = 10;
        guessNumber(n);
    }

    /**
     * используем бинарный поиск
     */
    private static int guessNumber(int n) {
        var minNum = 1;
        var maxNum = n;

        while (minNum <= maxNum) {
            // ищем середину
            var mid = minNum + (maxNum - minNum) / 2;
            switch (guess(mid)) {
                // если pick = mid возвращаем ответ
                case 0 -> {
                    return mid;
                }
                // если pick < mid уменьшаем минимальное значение
                case -1 -> maxNum = mid - 1;
                // если pick > mid увеличиваем максимальное значение
                case 1 -> minNum = mid + 1;
            }
        }

        return -1;
    }

    private static int guess(int n) {
        var pick = 6;
        return Integer.compare(pick, n);
    }
}
