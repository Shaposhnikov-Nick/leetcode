public class Solution_733_FloodFill {
    public static void main(String[] args) {
        var image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        var sr = 1; // индекс строки
        var sc = 1;// индекс ячейки в строке
        var color = 2;
        floodFill(image, sr, sc, color);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var startColor = image[sr][sc];
        if (startColor == color) return image;
        dfs(image, sr, sc, color, startColor);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int startColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length) return;
        if (image[sr][sc] != startColor) return;
        image[sr][sc] = newColor;

        dfs(image, sr + 1, sc, newColor, startColor);
        dfs(image, sr - 1, sc, newColor, startColor);
        dfs(image, sr, sc + 1, newColor, startColor);
        dfs(image, sr, sc - 1, newColor, startColor);
    }
}
