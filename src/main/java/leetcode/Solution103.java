package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution103 {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (level %2 == 0) {
                if (curr.left != null) {
                    oddStack.push(curr.left);
                }
                if (curr.right != null) {
                    oddStack.push(curr.right);
                }
            } else {
                if (curr.right != null) {
                    evenStack.push(curr.right);
                }
                if (curr.left != null) {
                    evenStack.push(curr.left);
                }
            }

        }
        output.add(levelList);
        return output;
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));

    }
}