package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang Song
 * @date 2022/7/22 16:23
 */
public class Q20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * @param s 待检验字符串
     * @return 是否是有效括号
     */
    public static boolean isValid(String s) {
        // 如果是左括号 入栈 如果是右括号就出栈并判断是否满足匹配
        if(s == null || s.length() < 2){
            return false;
        }
        // 左右括号映射关系
        Map<Character,Character> map = new HashMap<>(3);
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : chars){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            // 到这说明是右括号 需要判定能不能匹配到左括号
            if(stack.isEmpty()){
                return false;
            }
            char cl = stack.pop();
            if(c != map.get(cl)){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()[]{}"));
    }
}
