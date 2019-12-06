package linkedin;

import learn.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution297 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> nodeList = new ArrayList<>();
            level(root.left, root.right, nodeList);
            return nodeList.toArray().toString();
        }

        private void level(TreeNode tl, TreeNode tr, List<Integer> nodeList) {
            if (tl == null) {
                nodeList.add(null);
            } else {
                nodeList.add(tl.val);
                level(tl.left, tl.right, nodeList);
            }
            if (tr == null) {
                nodeList.add(null);
                return;
            } else {
                nodeList.add(tr.val);
                level(tr.left, tr.right, nodeList);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            TreeNode node = new TreeNode(-1);
            String[] str = data.split(",");
            level(node.left, node.right, str);
            return node;
        }

        private void level(TreeNode tl, TreeNode tr, String[] str) {
            for (int i=0; i<str.length; i++) {
                String s = str[i].replace("[", "").replace("]", "");
                if (s.equals("null")) {
                    break;
                } else {
                    int j = Integer.valueOf(s);
                    if (tl == null) {
                        tl = new TreeNode(j);
                        level(tl.left, tl.right, str);
                    }
                    if (tr == null) {
                        tr = new TreeNode(j);
                        level(tr.left, tr.right, str);
                    }
                }
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


}
