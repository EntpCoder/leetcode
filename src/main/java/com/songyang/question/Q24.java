package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;

/**
 * @author Yang Song
 * @date 2022/7/25 14:43
 */
public class Q24 {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * 1->2->3->4
     * 2->1->4->3
     * 思路
     * 1.前置节点连接到node2上
     * 2.node1.next = node2.next;
     * 3.node2.next = node1
     * 4.将node1保存成前置节点 用于下一次交换
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode dump = new ListNode(-1,head);
        ListNode node1 = dump.next,node2 = dump.next.next;
        ListNode pre = dump;
        while (node1 != null && node2 != null){
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
            node1 = node1.next;
            if(node1 != null){
                node2 = node1.next;
            }
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.createListNode("[1,2,3,4]");
        ListNodeUtils.print(swapPairs(listNode));
    }
}