/**
 * 404 Sum of Left Leaves
 *
 * Easy
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * Example 2:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */
fun main() {
    val node3 = TreeNode(3)
    val node9 = TreeNode(9)
    val node20 = TreeNode(20)
    val nod15 = TreeNode(15)
    val node7 = TreeNode(7)
    node3.left = node9
    node3.right = node20
    node20.left = nod15
    node20.right = node7
    sumOfLeftLeaves(node3)
}

/**
 * DFS обход в глубину
 * Берем каждый узел, проверяем его является ли он листовым и левым
 * ИСпользуем обходь в глубины для левого и правого узлов
 */
fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) return 0
    return sum(root, false)
}

private fun sum(node: TreeNode?, isLeft: Boolean): Int {
    // если узла нет, возвращаем 0
    if (node == null) return 0
    // если узел листовой и левый, возвращаем его значение
    if (node.left == null && node.right == null && isLeft) return node.`val`
    // рекурсивно обходим правые и левые узлы и складываем их значения
    return sum(node.left, true) + sum(node.right, false)
}