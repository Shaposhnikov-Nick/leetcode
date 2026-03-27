import java.util.List;

public class Solution_841_KeysAndRooms {
    public static void main(String[] args) {
//        var rooms = new int[][]{{1,3},{3,0,1},{2}, {0}};
        var rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        canVisitAllRooms(rooms);
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var visited = new boolean[rooms.size()];
        var firstRoomKeys = rooms.getFirst();
        visited[0] = true;
        firstRoomKeys.forEach(key -> dfs(rooms, key, visited));

        for (var room : visited) {
            if (!room) return false;
        }

        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int key, boolean[] visited) {
        if (key >= rooms.size() || key < 0 || visited[key]) return;

        var thisRoomKeys = rooms.get(key);
        visited[key] = true;

        thisRoomKeys.forEach(thisKey -> dfs(rooms, thisKey, visited));
    }
}
