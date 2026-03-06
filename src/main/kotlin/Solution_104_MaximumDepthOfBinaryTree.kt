import kotlin.math.max

fun main() {
    val root = arrayOf<Int?>(3, 9, 20, null, null, 15, 7)
    val node3 = TreeNode(3)
    val node9 = TreeNode(9)
    val node20 = TreeNode(20)
    val nod15 = TreeNode(15)
    val node7 = TreeNode(7)
    node3.left = node9
    node3.right = node20
    node20.left = nod15
    node20.right = node7
    maxDepth(node3)
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    return 1 + max(maxDepth(root.left), maxDepth(root.right))
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}