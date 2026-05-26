public class Solution_541_ReverseStringII {
    public static void main(String[] args) {
        var s = "abcdefg";
        var k = 2;
        reverseStr(s, k);
    }

    /**
     * Используем 2 указателя для подстроки длиной k.
     * Каждую вторую подстроку длиной k поочередно, начиная с первой, разворачиваем.
     * Подстроки между ними оставляем как есть.
     */
    private static String reverseStr(String s, int k) {
        // Два указателя для подстроки
        var left = 0;
        var right = k - 1;
        // StringBuilder для собирания новой строки
        var sb = new StringBuilder();
        var sArr = s.toCharArray();
        // Флаг, что нужно развернуть подстроку
        var reverse = true;

        // Если длина строки меньше длины подстроки k, то просто сразу разворачиваем ее
        if (s.length() < k) {
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(sArr[i]);
            }

            return sb.toString();
        }

        // Берем каждую подстроку  длиной k
        while (right <= s.length() + k) {
            // Если установлен флаг для реверса (для первой подстроки и потом через одну)
            if (reverse) {
                // Добавляем символы из подстроки в обратном порядке (разворачиваем подстроку
                // При этом проверяем, чтобы в конце строки указатель не вышел за пределы самоц строки
                // если последняя подстрока длиной меньше k
                var i = Math.min(sArr.length - 1, right);
                while (i >= left) {
                    sb.append(sArr[i]);
                    i--;
                }
                // Устанавливаем флаг, что следующую подстроку не нужно разворачивать
                reverse = false;
            } else {
                // Если подстроку не нужно разворачивать
                // Просто добавляем ее символы
                var i = left;
                while (i < sArr.length && i <= right) {
                    sb.append(sArr[i]);
                    i++;
                }
                // Устанавливаем флаг, что следующую подстроку нужно развернуть
                reverse = true;
            }

            // Сдвигаем указатели на следующую подстроку
            left = right + 1;
            right += k;
        }

        return sb.toString();
    }
}
