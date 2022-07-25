package com.songyang.question;

import com.songyang.util.node.ListNode;
import com.songyang.util.node.ListNodeUtils;
/**
 * @author Yang Song
 * @date 2022/7/25 10:03
 */
public class Q002 {
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
            此做法为第一版本(起始可以不用判断两个链表的长短 短链表后续置0就ok了 sum 为长链表+进位值)
         */
        int carry = 0;
        ListNode pre = null;
        ListNode result = l1;
        while (l1 != null && l2 != null){
            int value = l1.val + l2.val + carry;
            carry = value < 10 ? 0 : 1;
            l1.val = value < 10 ? value : value % 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            while (l2 != null){
                int value = l2.val + carry;
                carry = value < 10 ? 0 : 1;
                value = value < 10 ? value : value % 10;
                pre.next = new ListNode(value);
                pre = pre.next;
                l2 = l2.next;
            }
        }else{
            while (l1 != null){
                int value = l1.val + carry;
                carry = value < 10 ? 0 : 1;
                value = value < 10 ? value : value % 10;
                l1.val = value;
                pre = l1;
                l1 = l1.next;
            }
        }
        if(carry == 1){
            pre.next = new ListNode(1);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.createListNode("[9,9,9]");
        ListNode l2 = ListNodeUtils.createListNode("[9,9,9,9,9,9,9]");
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNodeUtils.print(listNode);
    }
//    public void addTwoNumbers(ListNode l1, ListNode l2,int carry){
//        if(l1 == null || l2 == null){
//            return;
//        }
//        int value = l1.val + l2.val + carry;
//        if(value > 10){
//            l1.val = value % 10;
//            carry = 1;
//        }else{
//            l1.val =value;
//        }
//        addTwoNumbers(l1.next,l2.next,carry);
//    }
}
