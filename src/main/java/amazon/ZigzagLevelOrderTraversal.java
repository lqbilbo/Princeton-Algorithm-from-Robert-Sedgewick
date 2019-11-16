package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        int level = 0;
        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();
        evenStack.push(root);

        List<Integer> levelList = new ArrayList<>();
        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {

            if (level % 2 == 0 && evenStack.isEmpty() || (level % 2 != 0 && oddStack.isEmpty())) {
                output.add(levelList);
                levelList = new ArrayList<>();
                level++;
                continue;
            }
            TreeNode curr = level % 2 == 0 ? evenStack.pop() : oddStack.pop();
            levelList.add(curr.val);
            if (level % 2 == 0) {
                if (curr.left != null) {
                    oddStack.push(curr.left);
                }
                if (curr.right != null) {
                    oddStack.push(curr.right);
                }
            } else {
                if (curr.left != null) {
                    evenStack.push(curr.left);
                }
                if (curr.right != null) {
                    evenStack.push(curr.right);
                }
            }
        }
        output.add(levelList);
        return output;
    }
}
