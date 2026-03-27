/**
 * 841 Keys and Rooms
 *
 * Medium
 *
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * Example 2:
 *
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 *
 *
 * Constraints:
 *
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 */
fun main() {
    val rooms = listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))
    canVisitAllRooms(rooms)
}

/**
 * Берем ключи в комнате 0
 * Для каждого ключа идем в соответствующую комнату и там берем други ключи
 * Каждю посещенную комнату отмечаем в visited
 * Если после обхода со всем ключами в visited все комнаты отмечены как посещенные, возвращаем true,
 * если какие-то комнаты не были посещены - возвращаеем false
 */
fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val visited = Array<Boolean>(rooms.size) { false }
    // Берем ключи в комнате 0
    val firstRoomKeys = rooms[0]
    // Каждю посещенную комнату отмечаем в visited
    visited[0] = true
    // Для каждого ключа идем в соответствующую комнату и там берем други ключи
    firstRoomKeys.forEach { key -> dfs(rooms, key, visited) }
    // Если после обхода со всем ключами в visited все комнаты отмечены как посещенные, возвращаем true,
    // если какие-то комнаты не были посещены - возвращаеем false
    return visited.all { it }
}

fun dfs(rooms: List<List<Int>>, key: Int, visited: Array<Boolean>) {
    // если ключ вне диапазоны комнат или комната уже была посещена то выходим
    if (key >= rooms.size || key < 0 || visited[key]) return

    // берем новые ключи
    val thisRoomKeys = rooms[key]
    // помечаем комнату как посещенную
    visited[key] = true

    // идем в другие комнаты
    thisRoomKeys.forEach { key -> dfs(rooms, key, visited) }
}