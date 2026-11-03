public class Solution_617_MergeTwoBinaryTrees {
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

        mergeTrees(node3, node3);
    }

    /**
     * DFS
     * Попарно складываем значения из соответстувющих узлов
     * Если каждый узел в паре - null, результирующий тоже будет null
     * Рекурсивно добавляем получившемуся узлу сумму правых и левых узлов
     */
    private static TreeNode2 mergeTrees(TreeNode2 root1, TreeNode2 root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
