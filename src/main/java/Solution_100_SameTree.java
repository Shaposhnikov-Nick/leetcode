public class Solution_100_SameTree {
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

        isSameTree(node3, node3);
    }

    /**
     * Сравниваем попарно каждый узел из двух деревьев
     */
    private static boolean isSameTree(TreeNode2 p, TreeNode2 q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
