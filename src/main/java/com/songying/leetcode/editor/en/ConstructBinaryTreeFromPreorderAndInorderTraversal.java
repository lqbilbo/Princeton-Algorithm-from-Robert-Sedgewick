//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search


package com.songying.leetcode.editor.en;

import learn.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution1 solution1 = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution1();
        Solution2 solution2 = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution2();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {

    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right)
            return null;

        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }
}

class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        // record the in-order items and their positions
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // dfs
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
                inorder.length - 1, inMap);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // calc the root position and divide the two arrays
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}