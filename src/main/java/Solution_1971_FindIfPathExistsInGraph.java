import java.util.*;

public class Solution_1971_FindIfPathExistsInGraph {
    public static void main(String[] args) {
        var n = 3;
        var source = 0;
        var destination = 2;
        var edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        validPath(n, edges, source, destination);
    }

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        var visited = new HashSet<Integer>();
        var queue = new ArrayDeque<Integer>();
        var graph = new HashMap<Integer, List<Integer>>();

        // Составляем граф для каждой вершины
        for (var edge : edges) {
            var v1 = edge[0];
            var v2 = edge[1];
            graph.computeIfAbsent(v1, _ -> new ArrayList<>()).add(v2);
            graph.computeIfAbsent(v2, _ -> new ArrayList<>()).add(v1);
        }

        // Добавляем первую вершину (source) в очередь и помечаем ее как посещенную
        queue.addLast(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            // Берем вершину из очереди, если она равна destination значит путь есть
            var current = queue.removeFirst();
            if (current == destination) return true;

            // Иначе берем из графа все вершины, с которыми у текущей (current) есть связь и, если их еще не посещали,
            // добавляем в очередь
            for (var neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.addLast(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        // Если искомой вершины не оказалось в очереди, значит пути к ней нет
        return false;
    }
}
