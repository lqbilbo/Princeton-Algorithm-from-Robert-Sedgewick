package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 三个容器：两个存放奇偶行的stack，一个存放level的结点数值的数组的list。
 * 奇数行为空或者偶数行为空时放入output，并重置level list，下降一层。
 * 否则取出奇数行或偶数行的元素，数值放入level list。
 * 往偶数行或奇数行的stack里push左右叶子结点。
 */
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
