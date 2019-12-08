package linkedin;

import java.util.*;

public class Solution150 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if (isDigit(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(Integer.valueOf(getResOfMath(tokens[i], leftOperand, rightOperand)));
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return 0;
    }

    private static boolean isDigit(String token) {
        char[] chars = token.toCharArray();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    private static int getResOfMath(String oper, int left, int right) {
        if (oper.equals("+")) {
            return left + right;
        } else
        if (oper.equals("-")) {
            return left - right;
        } else
        if (oper.equals("*")) {
            return left * right;
        } else {
            return left / right;
        }
    }

    public static void main(String[] args) {
//        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens = {"-1","1","*","-1","+"};
        System.out.println(evalRPN(tokens));

        List<String> list = new ArrayList<>();
        list.set(0, "123");

    }
}
