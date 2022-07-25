package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yang Song
 * @date 2022/7/22 17:02
 */
public class Q150 {
    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 注意两个整数之间的除法只保留整数部分。
     * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     */
    public static int evalRPN(String[] tokens) {
        /*
          1.如果遇到数字则入栈
          2.如果遇到操作符则出栈
          3.当出栈时需要一次性弹出两个元素进行计算
          4.将计算结果重新压入栈中
         */
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(isOperator(token)){

            }
        }
        return 0;
    }
    private static int compute(int a,int b,String operator){
        switch (operator){
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            default: return a/b;
        }
    }
    private static boolean isOperator(String token){
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

}
