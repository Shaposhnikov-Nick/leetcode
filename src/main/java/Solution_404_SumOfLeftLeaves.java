public class Solution_404_SumOfLeftLeaves {
    public static void main(String[] args) {
        var node3 = new TreeNode2(3);
        var node9 = new TreeNode2(9);
        var node20 = new TreeNode2(20);
        var nod15 = new TreeNode2(15);
        var node7 = new TreeNode2(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = nod15;
        node20.right = node7;

        sumOfLeftLeaves(node3);
    }

    /**
     * DFS обход в глубину
     * Берем каждый узел, проверяем его является ли он листовым и левым
     * ИСпользуем обходь в глубины для левого и правого узлов
     */
    private static int sumOfLeftLeaves(TreeNode2 root) {
        if (root == null) return 0;
        return sum(root, false);
    }

    private static int sum(TreeNode2 node, boolean isLeft) {
        // если узла нет, возвращаем 0
        if (node == null) return 0;
        // если узел листовой и левый, возвращаем его значение
        if (node.left == null && node.right == null && isLeft) return node.val;
        // рекурсивно обходим правые и левые узлы и складываем их значения
        return sum(node.left, true) + sum(node.right, false);
    }
}
