public class Solution_1009_ComplementOfBase10Integer {
    public static void main(String[] args) {
        var n = 5;
        bitwiseComplement(n);
    }

    private static int bitwiseComplement(int n) {
        // Обработка особого случая
        if (n == 0) return 1;

        // Находим количество бит
        int bitCount = 0;
        int temp = n;
        while (temp > 0) {
            bitCount++;
            temp /= 2;
        }

        // Создаем маску (все биты = 1)
        int mask = (int) (Math.pow(2, bitCount) - 1);

        // Инвертируем биты
        return mask - n;  // или mask ^ n (XOR)
    }
}
