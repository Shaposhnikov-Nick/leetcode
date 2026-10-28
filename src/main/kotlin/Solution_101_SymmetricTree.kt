/**
 * 101 Symmetric Tree
 *
 * Easy
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
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

    isSymmetric(node3)
}

/**
 * Сравниваем значения симметричных узлов
 */
fun isSymmetric(root: TreeNode?): Boolean {
    return root != null && symmetric(root.left, root.right)
}

fun symmetric(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    return (left.`val` == right.`val`) && symmetric(left.left, right.right) && symmetric(left.right, right.left)
}
