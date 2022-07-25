package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;

/**
 * @author Yang Song
 * @date 2022/7/25 15:29
 */
public class Q24Pro {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * 1->2->3->4
     * 2->1->4->3
     * 思路
     * 1.前置节点连接到node2上
     * 2.node1.next = node2.next;
     * 3.node2.next = node1
     * 4.将node1保存成前置节点 用于下一次交换 连接node2
     * 语法优化版本
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null){
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.createListNode("[1,2,3,4]");
        ListNodeUtils.print(swapPairs(listNode));
    }
}
