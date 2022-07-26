package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yang Song
 * @date 2022/7/26 15:19
 */
public class Q225MyStack {
    Deque<Integer> queue = new ArrayDeque<>();
    public void push(int x) {
        int length = queue.size();
        queue.addLast(x);
        for(int i = 0;i < length;i++){
            queue.addLast(queue.poll());
        }
    }
    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peekFirst();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
