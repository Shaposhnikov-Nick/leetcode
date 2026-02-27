/**
 * 1791 Find Center of Star Graph
 *
 * Easy
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 * Example 2:
 *
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * The given edges represent a valid star graph.
 */
fun main() {
    val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2))
    findCenter(edges)
}

/**
 * Есл вершина центральная, она будет в каждом ребре
 * Считаем количество появлений вершин в каждом ребре
 * Берем ту веришну, которая встречалась столько же раз, сколько всего ребер
 */
fun findCenter(edges: Array<IntArray>): Int {
    // key - номер вершины
    // value - количество ребер с этой вершиной
    val map = mutableMapOf<Int, Int>()

    // Считаем количество появлений вершин в каждом ребре
    edges.forEach {
        map.merge(it[0], 1, Int::plus)
        map.merge(it[1], 1, Int::plus)
    }

    // Берем ту веришну, которая встречалась столько же раз, сколько всего ребер
    return map.entries.first { it.value == edges.size }.key //.maxByOrNull { entry -> entry.value }!!.key
}

/**
 *  Упрощение пергвоо решения. Не нужно перебирать все ребра в графе.
 *  В звездном графе центральная вершина появляется в каждом ребре.
 *  Значит, она должна быть одной из двух вершин в первом ребре
 *  и одновременно одной из двух вершин во втором ребре.
 *  Проверяем первую вершину из первого ребра
 */
fun findCenter2(edges: Array<IntArray>): Int {
    return if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
        edges[0][0] // если она совпадает с какой-то из вершин второго ребра — это центр
    else
        edges[0][1] // иначе центр — вторая вершина из первого ребра
}