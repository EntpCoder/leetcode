package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;

/**
 * @author Yang Song
 * @date 2022/7/25 13:33
 */
public class Q2Pro {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 和
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        /*
            1.都没有进位 链表每位相加
            2.除最高位有进位 链表每位相加并且加上进位
            3.最高位进位 链表尾 +1
            4.链表长度不一样 以长的为准,短的剩余部分当成0处理
            5.每次将值接到当前节点的下一位(头节点需要单独处理)
         */
        ListNode head = null,tail = null;
        // 进位
        int carry = 0;
        // 以长节点为准 如果短节点 遍历完 值就置0
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            // 第一次 给一个头节点 之后头节点不动
            if(head == null){
                head = tail = new ListNode(sum%10);
            }else{
                // 将值接在当前位后面
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // 如果最高位进位 需在后面加上进位值
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.createListNode("[0,0,5]");
        ListNode l2 = ListNodeUtils.createListNode("[0,0,5]");
        ListNodeUtils.print(addTwoNumbers(l1, l2));
    }
}
