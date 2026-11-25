import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution_872_LeafSimilarTrees {
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

        leafSimilar(node3, node3);
    }

    /**
     * DFS
     * Обходим каждое дерево в одной и той же последовательности (сначала левый узел, потом правый)
     * и кладем значения листовых узлов в лист.
     * Потом сравниваем оба листа
     */
    private static boolean leafSimilar(TreeNode2 root1, TreeNode2 root2) {
        var values1 = new ArrayList<Integer>();
        var values2 = new ArrayList<Integer>();

        getValue(root1, values1);
        getValue(root2, values2);

        if (values1.size() != values2.size()) return false;

        for (int i = 0; i < values1.size(); i++) {
            if (!Objects.equals(values1.get(i), values2.get(i)))
                return false;
        }

        return true;
    }

    private static void getValue(TreeNode2 node, List<Integer> values) {
        if (node == null) return;

        // если узел листовой, берем его значение
        if (node.left == null && node.right == null) {
            values.add(node.val);
        }

        // идем сначала в левый узле
        getValue(node.left, values);
        // потом идем в правый узел
        getValue(node.right, values);
    }
}
