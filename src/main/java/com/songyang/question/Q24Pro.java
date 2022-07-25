package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;

/**
 * @author Yang Song
 * @date 2022/7/25 15:29
 */
public class Q24Pro {
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
