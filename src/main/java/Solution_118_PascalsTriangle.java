import java.util.ArrayList;
import java.util.List;

public class Solution_118_PascalsTriangle {
    public static void main(String[] args) {
        var numRows = 5;
        generate(numRows);
    }

    private static List<List<Integer>> generate(int numRows) {
        // результирующий треугольник
        var triangle = new ArrayList<List<Integer>>();
        // добавляем первую строку (вершину)
        triangle.addFirst(List.of(1));

        // добавляем следующие строки
        for (int i = 1; i < numRows; i++) {
            // создаем новую строку и заполняем ее единицами
            var row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                row.add(1);
            }

            // берем из треугольника предыдущую строку
            var prevRow = triangle.get(i - 1);

            // заполняем новую строку суммой значений из предыдущей строки
            // кроме первого и последнего элемента, они остаются 1
            for (int j = 1; j < i; j++) {
                row.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }

            // добавляем новую строку в треугольник
            triangle.add(row);
        }

        return triangle;
    }
}
