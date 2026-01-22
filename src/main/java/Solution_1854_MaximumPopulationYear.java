public class Solution_1854_MaximumPopulationYear {
    public static void main(String[] args) {
        var logs = new int[][]{
                new int[]{1950, 1961},
                new int[]{1960, 1971},
                new int[]{1970, 1981}
        };

        maximumPopulation(logs);
    }

    private static int maximumPopulation(int[][] logs) {
        // Создаем массив для хранения населения по годам
        // Индексы: 0 → 1950, 1 → 1951, ..., 100 → 2050
        int[] years = new int[101];

        // Проходим по всем людям
        for (int[] log : logs) {
            int birth = log[0];    // год рождения
            int death = log[1];    // год смерти

            // Человек живет в годы [birth, death - 1]
            // Например, если birth = 1950, death = 1961,
            // то человек жив в 1950, 1951, 1952, ..., 1960
            for (int year = birth; year < death; year++) {
                // Увеличиваем счетчик населения для этого года
                years[year - 1950]++;
            }
        }

        // Находим год с максимальным населением
        int maxPopulation = 0;
        int maxYear = 1950;

        for (int i = 0; i < years.length; i++) {
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                maxYear = i + 1950;  // Преобразуем индекс обратно в год
            }
        }

        return maxYear;
    }
}
