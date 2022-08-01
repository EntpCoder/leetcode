package com.songyang.question;

/**
 * @author Yang Song
 * @date 2022/8/1 19:54
 */
public class Q43 {
    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        // 0位
        StringBuilder zeroBit = new StringBuilder();
        // 最终结果
        StringBuilder result = new StringBuilder("0");
        // 两个字符串从后往前逐位遍历
        for(int i = n1;i >= 0;i--){
            // 每位的值
            int bit1 = num1.charAt(i) - '0';
            // 每乘一位的临时结果
            StringBuilder tempResult = new StringBuilder();
            // 进位
            int carry = 0;
            for (int j = n2;j >= 0;j--){
                int bit2 = num2.charAt(j) - '0';
                int bitMultiply = bit1 * bit2 + carry;
                int bitResult = bitMultiply % 10;
                carry = bitMultiply / 10;
                // 拼接临时结果
                tempResult.insert(0,bitResult);
            }
            // 拼接0位
            tempResult.append(zeroBit);
            if(carry != 0){
                tempResult.insert(0,carry);
            }
            // 下一次的0位
            zeroBit.append("0");
            // 临时结果相加
            result = addString(result,tempResult);
        }
        return result.toString();
    }
    public static StringBuilder addString(StringBuilder num1,StringBuilder num2){
        int i = num1.length() - 1, j = num2.length() - 1,carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int bitSum = x + y + carry;
            result.insert(0,bitSum % 10);
            carry = bitSum / 10;
            i--;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = multiply("123","456");
        System.out.println(s);
    }
}
