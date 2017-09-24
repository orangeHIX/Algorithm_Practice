package com.creaty.leetcode;

import java.util.Stack;

/**
 * Created by hyx on 2017/9/22.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(': case '[': case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                    else stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                    else stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                    else stack.pop();
                    break;
                default: return false;
            }
        }
        return stack.isEmpty();
    }
}
