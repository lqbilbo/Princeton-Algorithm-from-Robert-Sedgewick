package leetcode;

/**
 * there are two general strategies to traverse a tree:
 * 1.Depth First Search(DFS)
 * In this strategy, we adopt the depth as the priority, so that one would start from a root and reach all the way
 * down to certain leaf, and then back to root to reach another branch.
 * The DFS strategy can further be distinguished as preorder, inorder and postorder depending on the relative order
 * among the root node, left node and right node.
 * 2.Breadth First Search(BFS)
 * We scan through the tree level by level, following the order of height, from top to bottom. The nodes on higher level
 * would be visited before the ones with lower levels.
 */
class Solution426 {

    static Node first = null;
    static Node last = null;

    /**
     * intuition:
     * step1: inorder tranversal by recursion to connect the original BST
     * step2: connect the head and tail to make it circular
     *
     * Algorithm:
     * 1.Initiate the first and the last nodes as nulls.
     * 2.Call the standard inorder recursion helper(root):
     *  (1)If node is not null:
     *      a.Call the recursion for the left subtree [helper(node.left)].
     *      b.If the last node is not null, link the last and the current [node] nodes.
     *      c.Else initiate the [first] node.
     *      d.Mark the current node as the last one: [last = node].
     *      e.Call the recursion for the right subtree [helper(node.right)].
     *  (2)Link the first and the last nodes to close DLL ring and then the [first] node.
     *
     *  Time complexity: O(N)
     *  Space complexity: O(N)
     * @param node
     */
    public static void helper(Node node) {
        if (node != null) {
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }

    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);

        last.right = first;
        first.left = last;
        return first;
    }

    public static void main(String[] args) {
        Node node2 = new Node(2, new Node(1), new Node(3));
        Node node = new Node(4, node2, new Node(5));
        treeToDoublyList(node);
    }
}
