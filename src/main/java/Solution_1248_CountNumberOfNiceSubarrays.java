public class Solution_1248_CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        var nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        var k = 2;
        numberOfSubarrays(nums, k);
    }

    /**
     * Для упрощения подсчета заменим четные числа на 0, нечетные на 1.
     * Используем скользящие окна размеров от k до nums.size.
     * Проходим скользящим окном по массиву слева направо. Для первого окна размером k считаем сумму этого окна,
     * для остальных окон k+1..n добавляем к этой сумме nums[k+1], чтобы не пересчитывать ее каждый раз заново.
     * Двигаем скользящее окно, если сумма в окне равна k, считаем этот подмассив подхоядщим
     */
    private static int numberOfSubarrays(int[] nums, int k) {
        var niceSubarray = 0;
        var windowSum = 0;

        // заменим четные числа на 0, нечетные на 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }

        // берем скользящие окна размером от k до nums.size
        for (int windowLength = k; windowLength <= nums.length; windowLength++) {
            var prefixSum = 0;
            var left = 0;
            var right = 0;

            // для первого окна считаем сумму в окне
            if (windowLength == k) {
                while (right < windowLength) {
                    prefixSum += nums[right];
                    right++;
                }

                windowSum = prefixSum;

            } else {
                // для следующих окон находим их сумму путем добавления следующего числа к сумме предыдущего окна
                windowSum += nums[windowLength - 1];
                prefixSum = windowSum;
                right = windowLength;
            }

            // если сумма в окне равна искомой, увеличиваем счетчик
            if (prefixSum == k)
                niceSubarray++;

            // двигаем окно и считаем сумму в нем
            while (right < nums.length) {
                prefixSum = prefixSum + nums[right] - nums[left];
                // если сумма в окне равна искомой, увеличиваем счетчик
                if (prefixSum == k) niceSubarray++;
                left++;
                right++;
            }

        }

        return niceSubarray;
    }
}
