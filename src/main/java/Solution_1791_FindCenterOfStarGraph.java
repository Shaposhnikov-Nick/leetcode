public class Solution_1791_FindCenterOfStarGraph {
    public static void main(String[] args) {
        var edges = new int[][]{{1, 2}, {2, 3}, {4, 2}};
        findCenter(edges);
    }

    private static int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        else
            return edges[0][1];
    }
}
