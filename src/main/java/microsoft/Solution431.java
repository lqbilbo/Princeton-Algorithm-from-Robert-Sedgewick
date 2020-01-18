package microsoft;

import learn.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution431 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;

        TreeNode newRoot = new TreeNode(root.val);

        if (root.children.size() > 0) {
            Node firstChild = root.children.get(0);
            newRoot.left = this.encode(firstChild);
        }

        TreeNode sibling = newRoot.left;
        for (int i = 1; i < root.children.size(); ++i) {
            sibling.right = this.encode(root.children.get(i));
            sibling = sibling.right;
        }

        return newRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }

        Node newRoot = new Node(root.val, new ArrayList<>());

        TreeNode sibling = root.left;
        while (sibling != null) {
            newRoot.children.add(this.decode(sibling));
            sibling = sibling.right;
        }

        return newRoot;
    }
}
