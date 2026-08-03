/**
 * 657  Robot Return to Origin
 *
 * Easy
 *
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
 *
 * Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
 *
 * Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 *
 *
 *
 * Example 1:
 *
 * Input: moves = "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * Example 2:
 *
 * Input: moves = "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 *
 *
 * Constraints:
 *
 * 1 <= moves.length <= 2 * 104
 * moves only contains the characters 'U', 'D', 'L' and 'R'.
 */
fun main() {
    val moves = "UD"
    judgeCircle(moves)
}

/**
 * Исходим из того, что чтобы вернуться в начальную точку, количество ходов ввер = количество ходов вниз и количество ходов
 * вправо = количество ходов влево.
 * Можно посчитать количество ходов и сравнить
 */
fun judgeCircle(moves: String): Boolean {
    val map = HashMap<Char, Int>()

    for (ch in moves) {
        map.merge(ch, 1, Int::plus)
    }

    return !(map['U'] != map['D'] || map['L'] != map['R'])
}

/**
 * Более простой подсчет без HashMap, считается точка по оси x и по оси y
 */
fun judgeCircle2(moves: String): Boolean {
    // Конечная точка по оси x
    var x = 0
    // Конечная точка по оси y
    var y = 0
    for (i in moves.toCharArray()) {
        when (i) {
            'R' -> x += 1
            'L' -> x -= 1
            'U' -> y += 1
            'D' -> y -= 1
            else -> println("Invalid move!")
        }
    }
    return (x == 0) && (y == 0)
}