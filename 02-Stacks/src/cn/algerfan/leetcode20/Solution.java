package cn.algerfan.leetcode20;

import cn.algerfan.stack.ArrayStack;

/**
 * 20. 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:
 输入: "()"
 输出: true
 示例 2:
 输入: "()[]{}"
 输出: true
 示例 3:
 输入: "(]"
 输出: false
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
