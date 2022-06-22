package javacode.stack;

import java.util.*;

/**
 * @Author duhaojun
 * @Date 2022/6/2
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('}','{');
        pairs.put(']','[');
        pairs.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsValue(c)){
                stack.push(c);
            } else {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(c))){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        ValidParentheses20 valid = new ValidParentheses20();
        System.out.println(valid.isValid("{()[{}]}"));
    }
}
