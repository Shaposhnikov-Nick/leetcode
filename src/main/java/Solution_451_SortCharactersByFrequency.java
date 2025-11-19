import java.util.*;
import java.util.stream.Collectors;

public class Solution_451_SortCharactersByFrequency {
    public static void main(String[] args) {
        var s = "loveleetcode";
        frequencySort(s);
    }

    private static String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        var sArr = s.toCharArray();

        // считаем количество совпадений символов в строке
        for (var letter : sArr) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        // преобразовываем массив в список
        var charList = new ArrayList<Character>();
        for (var letter : sArr) {
            charList.add(letter);
        }

        // создаем компаратор для сортировки символов в списке
        Comparator<Character> comparator = (ch1, ch2) -> {
            var res = map.get(ch2) - map.get(ch1);
            if (res == 0) return ch2 - ch1;
            else return res;
        };

        // сортируем список с компаратором
        charList.sort(comparator);
        return charList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    /**
     * Решение с PriorityQueue
     * <p>
     * Шаг 1: Подсчет частот символов
     * <p>
     * <pre>
     * Map<Character, Integer> map = new HashMap<>();
     * for (char c : s.toCharArray()) {
     *    map.put(c, map.getOrDefault(c, 0) + 1);
     * }
     * </pre>
     * <p>
     * Что происходит: Создается HashMap, где ключ - символ, значение - сколько раз он встречается в строке.
     * <p>
     * Шаг 2: Создание Max Heap
     * <pre>
     * PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
     * maxHeap.addAll(map.entrySet());
     * </pre>
     * <p>
     * Что происходит:
     * <p>
     * Создается приоритетная очередь (Max Heap) для пар Character-Integer
     * <p>
     * Компаратор (a, b) → b.getValue() - a.getValue() сортирует по убыванию частоты
     * <p>
     * Все элементы из HashMap добавляются в кучу
     * <p>
     * Шаг 3: Извлечение из кучи и построение строки
     * <pre>
     * while (!maxHeap.isEmpty()) {
     * Map.Entry<Character, Integer> entry = maxHeap.poll();
     *  char c = entry.getKey();
     *  int count = entry.getValue();
     * sb.append(String.valueOf(c).repeat(Math.max(0, count)));
     *  }
     * </pre>
     * <p>
     * Что происходит:
     * <p>
     * maxHeap.poll() извлекает элемент с наибольшей частотой
     * <p>
     * Для каждого символа добавляем в строку столько раз, сколько он встречался
     * <p>
     * String.valueOf(c).repeat(count) повторяет символ count раз
     * <p>
     * Преимущества этого подхода:
     * <p>
     * Эффективность: Max Heap обеспечивает O(log n) для вставки/удаления
     * <p>
     * Читаемость: Код легко понять
     * <p>
     * Правильная сортировка: Символы с большей частотой всегда идут первыми
     * <p>
     * Временная сложность:
     * <p>
     * O(n) для подсчета частот
     * <p>
     * O(k log k) для построения кучи (где k - количество уникальных символов)
     * <p>
     * O(n) для построения результирующей строки
     */
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char c = entry.getKey();
            int count = entry.getValue();
            sb.append(String.valueOf(c).repeat(Math.max(0, count)));
        }
        return sb.toString();
    }

    private static String frequencySort2(String s) {
        var map = new HashMap<Character, Integer>();
        var sArr = s.toCharArray();
        for (var letter : sArr) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        // Создаем массив пар (char, frequency) и сортируем его
        Character[] charArr = new Character[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            charArr[i] = sArr[i];
        }

        Arrays.sort(charArr, (ch1, ch2) -> {
            int freqCompare = map.get(ch2).compareTo(map.get(ch1));
            return freqCompare != 0 ? freqCompare : ch2.compareTo(ch1);
        });

        var builder = new StringBuilder();
        for (var letter : charArr) {
            builder.append(letter);
        }
        return builder.toString();
    }
}
