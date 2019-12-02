package leetcode;

import java.util.Stack;

class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') {
                stack1.push(c);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        for (int i=0; i<T.length(); i++) {
            char c = T.charAt(i);
            if (c != '#') {
                stack2.push(c);
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        if (!stack1.isEmpty() && !stack2.isEmpty()) {
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (!stack1.pop().equals(stack2.pop())) {
                    return false;
                }
            }
            if (!stack1.isEmpty() || !stack2.isEmpty()) return false;
            return true;
        }
        return false;
    }


    /* ********************** two pointer ********************************************/

    /**
     * intuition:
     *
     * When writing a character, it may or may not be part of the final string depending on how many backspace
     * keystrokes occur in the future.
     *
     * If instead we iterate through the string in reverse, then we will know how many backspace characters we have
     * seen, and therefore whether the result includes our character.
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompareWithTwoPointer(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
