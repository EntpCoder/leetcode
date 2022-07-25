package com.songyang.question;

import java.util.Arrays;

/**
 * @author Yang Song
 * @date 2022/7/25 9:04
 */
public class Q66 {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits 原数组
     * @return +1后数组
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        /*
          只需关注末尾出现多少个9就行
          1.末尾没9,直接末尾+1
          2.末尾有9,找到第一个不为9的数,+1,后面的全置0
          3.全为9 新数组长度加1,首位置0
         */
        int n = digits.length;
        for (int i = n -1; i >= 0; --i) {
            // 找到第一个不为9的数
            if(digits[i] != 9){
                ++digits[i];
                // 第一个不为9的数后面全置0
                for(int j = i + 1;j < n;++j){
                    digits[j] = 0;
                }
                return digits;
            }
        }
        // 如果全为9
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

}
