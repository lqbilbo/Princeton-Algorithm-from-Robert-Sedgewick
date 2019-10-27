package algs4.lesson2;

import common.StdIn;
import common.StdOut;

public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("))  ;
            else if (s.equals("+"))  ops.push(s);
            else if (s.equals("*"))  ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+"))  vals.push(vals.pop() + vals.pop());
                else if (op.equals("*"))  vals.push(vals.pop() * vals.pop());
            }
            else  vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
