package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yang Song
 * @date 2022/7/26 19:19
 */
public class Q239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        /* 出队
           如果看到的元素比队尾大 那么队尾的元素一定不是窗口中的最大元素,这个元素就应该移除队尾
           当队首元素不在窗口内 应当移除队首元素
           入队
           如果看到元素比队尾小 我们要保存 因为当前元素虽然在当前窗口不是最大的，但是可能在下一个窗口是最大的
           队列里存的是啥  下标
         */
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0;i < nums.length;i++){
            // 出队
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            //如果队首元素不在窗口里 需要出队
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.removeFirst();
            }
            deque.addLast(i);
            // 什么时候添加结果 在窗口形成后 添加结果
            if(i >= k-1 && !deque.isEmpty()){
                result[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
