/**
 * 100 Same Tree
 *
 * Easy
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
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

    isSameTree(node3, node3)
}

/**
 * Сравниваем попарно каждый узел из двух деревьев
 */
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}