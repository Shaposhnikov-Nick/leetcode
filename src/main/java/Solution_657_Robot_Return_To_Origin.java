public class Solution_657_Robot_Return_To_Origin {
    public static void main(String[] args) {
        var moves = "UD";
        judgeCircle(moves);
    }

    /**
     * Считаем каждый ход и вычисляем конечную точку робота
     */
    private static boolean judgeCircle(String moves) {
        // Конечная точка по оси x
        var x = 0;
        // Конечная точка по оси y
        var y = 0;
        for (var ch : moves.toCharArray()) {
            switch (ch) {
                case ('U') -> y++;
                case ('D') -> y--;
                case ('R') -> x++;
                case ('L') -> x--;
            }
        }

        return x == 0 && y == 0;
    }
}
