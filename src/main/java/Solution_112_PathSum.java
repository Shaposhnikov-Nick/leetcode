public class Solution_112_PathSum {
    public static void main(String[] args) {
        var node1 = new TreeNode2(1);
        var node2 = new TreeNode2(2);
        var node5 = new TreeNode2(5);
        var node4 = new TreeNode2(4);
        var node7 = new TreeNode2(7);
        var node8 = new TreeNode2(8);
        var node11 = new TreeNode2(11);
        var node13 = new TreeNode2(13);

        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4;
        node4.right = node1;

        var targetSum = 22;

        hasPathSum(node5, targetSum);
    }

    /**
     * DFS обход в глубину
     * считаем сумму в каждой ветви
     * если узел листвой и сумма до него равна targetSum, возвращаем true
     * иначе идем в его левый и правй узлы и считаем сумму в них
     */
    private static boolean hasPathSum(TreeNode2 root, int targetSum) {
        if (root == null) return false;
        return sum(root, 0, targetSum);
    }

    private static boolean sum(TreeNode2 node, int currentSum, int targetSum) {
        if (node == null) return false;

        // считаем сумму в каждой ветви
        int newSum = currentSum + node.val;

        // если узел листвой и сумма до него равна targetSum, возвращаем true
        if (node.left == null && node.right == null && newSum == targetSum) {
            return true;
        }

        // иначе идем в его левый и правй узлы и считаем сумму в них
        return sum(node.left, newSum, targetSum) || sum(node.right, newSum, targetSum);
    }
}
