package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;

/**
 * @author Yang Song
 * @date 2022/7/27 10:17
 */
public class Q061Pro {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        /*
            1. 原链表尾需要连接到原先的头上 记录链表长度
            2. k = k % size
            3. 新头节点在是size - k位置上
            4. 新尾的下一个新头 新尾.next = null
            5. 注意边界值
         */
        ListNode cur = head;
        int size = 1;
        // 先走一遍链表 记录链表大小 并且将链表尾连接到链表头(环形链表)
        while (cur.next != null){
            size++;
            cur = cur.next;
        }
        k = k % size;
        if(k == 0){
            return head;
        }
        cur.next = head;
        // 当前cur在旧链表末尾
        k = size - k;
        while (k > 0){
            k--;
            cur = cur.next;
        }
        // 当前cur在新链表的末尾
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeUtils.createListNode("[1,2,3,4,5]");
        ListNode rotateRight = rotateRight(node, 2);
        ListNodeUtils.print(rotateRight);
    }
}
