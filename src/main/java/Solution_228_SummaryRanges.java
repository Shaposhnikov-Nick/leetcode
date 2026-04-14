import java.util.ArrayList;
import java.util.List;

public class Solution_228_SummaryRanges {
    public static void main(String[] args) {
        var nums = new int[]{0, 1, 2, 4, 5, 7};
        summaryRanges(nums);
    }

    private static List<String> summaryRanges(int[] nums) {
        var ranges = new ArrayList<String>();

        // Используем 2 указателя
        // Указатель l обозначает начало диапазона, указатель r - конец диапазона
        var l = 0;
        var r = 0;

        while (r < nums.length) {
            // Двигаем r вправо, пока сохраняется условие, что каждое следующее число больше предыдущего на 1
            while (r < nums.length - 1 && nums[r + 1] - nums[r] == 1) {
                r++;
            }

            var range = "";
            // Если диапазон более одного числа, создаем строку с этим диапазоном
            if (r > l) range = String.format("%d->%d", nums[l], nums[r]);
                // Если в диапазоне одно число, добавляем его
            else range = String.valueOf(nums[l]);

            ranges.add(range);

            // Ставим оба указателя на следующую ячейку за этим диапазоном
            r++;
            l = r;
        }

        return ranges;
    }
}
