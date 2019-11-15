package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public List < Integer > inorderTraversal(TreeNode root) {
        List< Integer > res = new ArrayList< >();
        Stack <TreeNode> stack = new Stack< >();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
//        PatternMatch regrex = new PatternMatch();
//        regrex.setPattern("(!|?|'|,|;|.)");
//        if (regrex.compile(paragraph)) {
//
//        }
        String paragraph = "abc, ebd wcrt! sdfsd.";
        StringBuilder word = new StringBuilder();
        char[] paragraphArr = paragraph.toCharArray();
        for (char c : paragraphArr) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            }

        }
        for (int i = 0; i < paragraphArr.length; i++) {
            System.out.println(paragraphArr[i]);
        }
    }

}
