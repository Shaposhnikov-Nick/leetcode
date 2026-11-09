public class Solution_226_InvertBinaryTree {
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

        invertTree(node3);
    }

    private static TreeNode2 invertTree(TreeNode2 root) {
        if (root == null) return null;

        // Меняем местами левое и правое поддеревья
        var tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // Рекурсивно инвертируем поддеревья
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
