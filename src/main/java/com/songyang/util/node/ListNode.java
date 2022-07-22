package com.songyang.util.node;

/**
 * @author Yang Song
 * @date 2022/7/21 16:49
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this(val, null);
    }
    public ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
