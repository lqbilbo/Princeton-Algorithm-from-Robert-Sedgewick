package leetcode;

class Solution426 {

    static Node first = null;
    static Node last = null;

    /**
     * intuition:
     * step1: inorder tranversal by recursion to connect the original BST
     * step2: connect the head and tail to make it circular
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
