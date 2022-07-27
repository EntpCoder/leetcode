package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;

/**
 * @author Yang Song
 * @date 2022/7/27 8:59
 */
public class Q061 {
    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        /*
            1. 原链表尾需要连接到原先的头上
            2. 原链表尾-k个节点是新的链表尾
            3. 原链表尾-k个节点.next是新链表头
            4. 保存好新head之后 新链表尾.next断开
            5. fast先走k步 fast到末尾时 low就是新的链表尾 low.next就是新的链表头
            6. 当k的长度大于链表长度怎么办?总不能一直走吧?第一反应是fast走k%size次
            7. 所以需要记录链表长度(如果k > size 会用到) 保证fast最多走第二遍就可以确定
         */
        ListNode low = head, fast = head;
        int size = 0;
        // 快指针先走k步
        while (k > 0){
            ++size;
            --k;
            // 当快指针走到尾时 下一步走头节点
            // 同时取余k 保证最坏情况下第二遍fast 到low的+k位置
            if(fast.next == null){
                fast = head;
                k = k % size;
                // k == 0 证明不需要动 直接返回旧链表即可
                if(k == 0){
                    return head;
                }
            }else{
                fast = fast.next;
            }
        }
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        // 原尾接头 新尾的下一个是新头 新尾.next清空
        fast.next = head;
        ListNode newHead = low.next;
        low.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = ListNodeUtils.createListNode("[1,2,3,4,5]");
        ListNode rotateRight = rotateRight(node, 22);
        ListNodeUtils.print(rotateRight);
    }
}
