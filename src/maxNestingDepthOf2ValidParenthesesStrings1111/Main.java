package maxNestingDepthOf2ValidParenthesesStrings1111;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String seq_1 = "(()())";
        int expect_1 = 1; // {0, 1, 1, 1, 1, 0}
        check(expect_1, seq_1, solution.maxDepthAfterSplit(seq_1));

        String seq_2 = "()(())()";
        int expect_2 = 1; // {0, 0, 0, 1, 1, 0, 0, 0}
        check(expect_2, seq_2, solution.maxDepthAfterSplit(seq_2));

        String seq_3 = "()((()))()";
        int expect_3 = 2; // {0, 0, 0, 1, 0, 0, 1, 0, 0, 0}
        check(expect_3, seq_3, solution.maxDepthAfterSplit(seq_3));

        String seq_4 = "(((()))((())))";
        int expect_4 = 2; // {0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0}
        check(expect_4, seq_4, solution.maxDepthAfterSplit(seq_4));
    }

    private static void check(int expect, String seq, int[] ans) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        int depth1 = 0 ,depth2 = 0;

        for (int i = 0; i < ans.length; i++) {
            int whichOne = ans[i];
            if (whichOne == 0) {
                depth1 = Math.max(depth1, pushBracketIntoStack(stack1, seq.charAt(i)));
            } else {
                depth2 = Math.max(depth2, pushBracketIntoStack(stack2, seq.charAt(i)));
            }
        }
        if (stack1.empty() && stack2.empty() && Math.max(depth1, depth2) == expect) {
            System.out.println("pass");
        } else {
            System.out.println("Expect:" + expect);
            System.out.println("Actual:" + Math.max(depth1, depth2));
        }
    }

    private static int pushBracketIntoStack(Stack<Character> stack, char c) {
        if (stack.empty() || c == '(') {
            stack.push(c);
        } else {
            stack.pop();
        }
        return stack.size();
    }

}
