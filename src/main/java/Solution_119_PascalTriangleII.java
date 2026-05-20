import java.util.ArrayList;
import java.util.List;


public class Solution_119_PascalTriangleII {
    public static void main(String[] args) {
        var rowIndex = 0;
        getRow(rowIndex);
    }

    /**
     * Создаем массив для хранения строк треугольника
     * Добавляем две первые строки для упрощения последующих вычислений
     * Начиная с 3-й строки считаем каждое значение как сумму двух на предыдущей строке
     * В начале и конце новой строки добавляем 1
     */
    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        // Создаем массив для хранения строк треугольника
        var triangle = new ArrayList<List<Integer>>();
        // Добавляем две первые строки для упрощения последующих вычислений
        triangle.add(List.of(1));
        triangle.add(List.of(1, 1));

        // Начиная с 3-й строки считаем каждое значение как сумму двух на предыдущей строке
        for (int i = 2; i <= rowIndex; i++) {
            var lastRow = triangle.getLast();
            var newRow = new ArrayList<Integer>();

            for (int j = 0; j < lastRow.size(); j++) {
                // В начале новой строки добавляем 1
                if (j == 0) newRow.add(1);
                else {
                    var value = lastRow.get(j - 1) + lastRow.get(j);
                    newRow.add(value);
                }
            }

            // В конце новой строки добавляем 1
            newRow.add(1);

            triangle.add(newRow);
        }

        // Возвращаем последнюю нижнюю строку треугольника
        return triangle.getLast();
    }
}
