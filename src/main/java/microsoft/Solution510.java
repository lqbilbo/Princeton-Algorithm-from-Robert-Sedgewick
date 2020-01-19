package microsoft;

public class Solution510 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    /*
    todo code template memorize [BST successor]
  */
    public Node inorderSuccessor(Node x) {
        // the successor is somewhere lower in the right subtree
        if (x.right != null) {
            x = x.right;
            while (x.left != null) x = x.left;
            return x;
        }

        // the successor is somewhere upper in the tree
        while (x.parent != null && x == x.parent.right) x = x.parent;
        return x.parent;
    }
}
