package greedyAlgorithms.BalancedBrackets;

import java.util.Stack;

public class BalancedBrackets {

    // Complete the isBalanced function below.

    void match(char c, Stack<Character> stack) {
        if (stack.isEmpty())
            throw new RuntimeException("NO");
          char peekC = stack.peek().charValue();  
        if (peekC != c)
            throw new RuntimeException("NO");
        stack.pop();
    }

    String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        // s.chars().mapToObj(ch -> {
        for (char c : s.toCharArray()) {
            try {
                switch (c) {
                    case '{':
                    case '[':
                    case '(':
                        stack.add((char) c);
                        break;
                    case '}':
                        match('{', stack);
                        break;
                    case ']':
                        match('[', stack);
                        break;
                    case ')':
                        match('(', stack);
                        break;
                    default:
                        throw new RuntimeException("Character inválido");
                }
            } catch (RuntimeException e) {
                return e.getMessage();
            }
        }
        // });

        return stack.isEmpty() ? "YES" : "NO";

    }

}