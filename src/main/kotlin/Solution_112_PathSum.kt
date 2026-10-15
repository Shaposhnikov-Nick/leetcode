/**
 * 112 Path Sum
 *
 * Easy
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There are two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node5 = TreeNode(5)
    val node4 = TreeNode(4)
    val node7 = TreeNode(7)
    val node8 = TreeNode(8)
    val node11 = TreeNode(11)
    val node13 = TreeNode(13)

    node5.left = node4
    node5.right = node8
    node4.left = node11
    node11.left = node7
    node11.right = node2
    node8.left = node13
    node8.right = node4
    node4.right = node1

    val targetSum = 22

    hasPathSum(node5, targetSum)
}


/**
 * DFS обход в глубину
 * считаем сумму в каждой ветви
 * если узел листвой и сумма до него равна targetSum, возвращаем true
 * иначе идем в его левый и правй узлы и считаем сумму в них
 */
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    return sum(root, 0, targetSum)
}

fun sum(node: TreeNode?, currentSum: Int, targetSum: Int): Boolean {
    if (node == null) return false

    // считаем сумму в каждой ветви
    val newSum = currentSum + node.`val`

    // если узел листвой и сумма до него равна targetSum, возвращаем true
    if (node.right == null && node.left == null && newSum == targetSum) return true

    // иначе идем в его левый и правй узлы и считаем сумму в них
    return sum(node.left, newSum, targetSum) || sum(node.right, newSum, targetSum)
}