package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yang Song
 * @date 2022/7/26 14:21
 */
public class Q232MyQueue {
    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     * 实现 MyQueue 类：
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     * 说明：
     * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可
     * ===============================================================================
     * 队列是先入先出
     * 栈是先入后出
     * stackA负责入队↓
     * stackB负责出队↓
     */
    private final Deque<Integer> stackA = new ArrayDeque<>();
    private final Deque<Integer> stackB = new ArrayDeque<>();
    /**
     * 队列头
     */
    private int head;
    public void push(int x) {
        // 如果stackA为空的时候第一个加入stackA的元素就是队首
        if(stackA.isEmpty()){
            head = x;
        }
        stackA.push(x);
    }

    public int pop() {
        // *stackB不为空的时候直接弹b就行
        if(!stackB.isEmpty()){
            return stackB.pop();
        }
        // 用两个栈颠倒顺序
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }

    /**
     * 看队首
     * @return 返回队首
     */
    public int peek() {
        // *stackB不为空的时候队列头就是b的栈顶 否则就是stackA的栈底也就是head
        if(!stackB.isEmpty()){
            return stackB.peek();
        }
        return head;
    }
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
