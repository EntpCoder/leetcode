package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yang Song
 * @date 2022/7/25 19:14
 */
public class Q739 {
    /**
     * 给定一个整数数组temperatures，表示每天的温度，
     * 返回一个数组answer，其中answer[i]是指对于第 i 天，
     * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
     *
     * @param temperatures 每日温度
     * @return 结果数组
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[0];
        }
        /*
            0. 6 5 4 3 2 1 7 没遇到7时需要一直存 直到遇到7才出结果
            1. 当前温度没有遇到比它大的需要保存
            2. 温度变量应该是正着存 倒着出结果的  栈
            3. 出栈规则 遇到比栈顶元素大的值 出栈(一直弹到比栈顶小于等于的时候)
            4. 入栈规则 如果当前元素比栈顶元素小 入栈 等待比他大的元素出现
            5. 每次比较都要看栈顶
         */
        // 栈里一般存下标
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        // 肯定要遍历一次集合
        for(int i = 0;i < temperatures.length;i++){
            // 当前元素i 的值比栈顶大,则出栈并计算结果
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ){
                int index = stack.pop();
                result[index] = i -index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }
}
