public class Solution_48_RotateImage {
    public static void main(String[] args) {
        var matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
    }

    private static void rotate(int[][] matrix) {
        var n = matrix.length;

        // Проходим по слоям от внешнего к внутреннему
        for (int layer = 0; layer < n / 2; layer++) {
            // граница текущего слоя (индекс последней строки и последнего столбца текущего слоя)
            var last = n - 1 - layer;
            // Проходим по элементам вдоль верхней стороны слоя
            for (int i = layer; i < last; i++) {
                // смещение вдоль стороны слоя (сколько элементов мы прошли от начала слоя)
                var offset = i - layer;
                // Сохраняем верхний левый элемент
                var temp = matrix[layer][i];
                // Левый нижний → левый верхний
                matrix[layer][i] = matrix[last - offset][layer];
                // Правый нижний → левый нижний
                matrix[last - offset][layer] = matrix[last][last - offset];
                // Правый верхний → правый нижний
                matrix[last][last - offset] = matrix[i][last];
                // Правый верхний (temp) → правый верхний
                matrix[i][last] = temp;
            }
        }
    }
}
