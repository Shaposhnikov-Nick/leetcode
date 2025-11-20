import java.util.ArrayList;
import java.util.List;

public class Solution_989_AddToArrayFormOfInteger {
    public static void main(String[] args) {
        var num = new int[]{2, 1, 5};
        var k = 806;
        addToArrayForm(num, k);
    }

    private static List<Integer> addToArrayForm(int[] num, int k) {
        var result = new ArrayList<Integer>();
        var carry = k;
        var i = num.length - 1;

        // Проходим по массиву справа налево и добавляем k
        while (i >= 0 || carry > 0) {
            // Если еще есть цифры в массиве, добавляем их
            if (i >= 0) {
                carry += num[i];
                i--;
            }
            // Добавляем младший разряд в результат
            result.add(carry % 10);
            // Переносим старший разряд
            carry /= 10;
        }

        // Разворачиваем результат, так как добавляли с младших разрядов
        return result.reversed();
    }
}
