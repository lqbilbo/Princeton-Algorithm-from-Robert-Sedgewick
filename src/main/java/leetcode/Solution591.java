package leetcode;

import java.util.Stack;

public class Solution591 {

    Stack< String > stack = new Stack < > ();
    boolean contains_tag = false;
    public boolean isValidTagName(String s, boolean ending) {
        if (s.length() < 1 || s.length() > 9)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isUpperCase(s.charAt(i)))
                return false;
        }
        if (ending) {
            if (!stack.isEmpty() && stack.peek().equals(s))
                stack.pop();
            else
                return false;
        } else {
            contains_tag = true;
            stack.push(s);
        }
        return true;
    }
    public boolean isValidCdata(String s) {
        return s.indexOf("[CDATA[") == 0;
    }

    /**
     * 直觉和算法
     *
     * 题目的重点在于将所有异常的case分类和规则搞清楚
     * case1.必须有关闭的tag，否则无效
     * case2.tag名字必须都是大写，且长度小于10个字符
     * case3.有效的内容必须包含CDATA标签及其他字符，否则无效
     * case4.需要校验tag的对称性
     * case5.CDATA中的标签不需要校验有效性
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param code
     * @return
     */
    public boolean isValid(String code) {
        if (code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>')
            return false;
        for (int i = 0; i < code.length(); i++) {
            boolean ending = false;
            int closeindex;
            if(stack.isEmpty() && contains_tag)
                return false;
            if (code.charAt(i) == '<') {
                if (!stack.isEmpty() && code.charAt(i + 1) == '!') {
                    closeindex = code.indexOf("]]>", i + 1);
                    if (closeindex < 0 || !isValidCdata(code.substring(i + 2, closeindex)))
                        return false;
                } else {
                    if (code.charAt(i + 1) == '/') {
                        i++;
                        ending = true;
                    }
                    closeindex = code.indexOf('>', i + 1);
                    if (closeindex < 0 || !isValidTagName(code.substring(i + 1, closeindex), ending))
                        return false;
                }
                i = closeindex;
            }
        }
        return stack.isEmpty() && contains_tag;
    }
}
