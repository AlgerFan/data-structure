package cn.algerfan.leetcode20;

import cn.algerfan.stack.ArrayStack;

/**
 * @author algerfan
 * @date 2019/10/24 21:33
 */
public class Solution {

    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(c == ')' && stack.pop() != '(') {
                    return false;
                }
                if(c == ']' && stack.pop() != '[') {
                    return false;
                }
                if(c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }

}
